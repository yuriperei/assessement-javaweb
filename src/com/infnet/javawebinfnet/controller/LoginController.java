/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infnet.javawebinfnet.controller;

import com.infnet.javawebinfnet.model.Usuario;
import com.infnet.javawebinfnet.model.UsuarioDao;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author DesenvolvedorJava
 */
@Controller
@Transactional
public class LoginController {

    @Autowired
    private UsuarioDao dao;

    @Autowired
    private HttpSession session;

    private ModelAndView retorno = new ModelAndView();

    @RequestMapping("/cadastro")
    public String inicio() {
        return "usuario/cadastro";
    }

    @RequestMapping(value = {"/cadastro"}, method = RequestMethod.POST)
    public ModelAndView cadastro(Usuario usuario) {
        retorno.addObject("dados", usuario);
        dao.inserir(usuario);
        retorno.setViewName("usuario/cadastro");
        return retorno;
    }

    @RequestMapping(value = "/login")
    public String login() {
        retorno.getModelMap().remove("erro");
        return "usuario/index";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public ModelAndView login(Usuario usuario) {

        try {
            Usuario userBd = dao.buscarPorEmail(usuario.getEmail());

            if (userBd != null
                    && userBd.getEmail().equals(usuario.getEmail())
                    && userBd.getSenha().equals(usuario.getSenha())) {
                session.setAttribute("usuario", userBd);
                retorno.setViewName("redirect:dashboard");
            } else {
                this.erroAcesso();
            }

        } catch (NoResultException e) {
            // Nenhum resultado encontrado
            this.erroAcesso();
        }

        return retorno;
    }

    @RequestMapping("/dashboard")
    public String dashboard() {
        return "dashboard/index";
    }

    @RequestMapping("/deslogar")
    public String deslogar() {
        session.removeAttribute("usuario");
        return "usuario/index";
    }

    private void erroAcesso() {
        retorno.addObject("erro", "Os dados informado estão incorretos!");
        retorno.setViewName("usuario/index");
    }

}
