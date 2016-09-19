/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infnet.javawebinfnet.controller;

import com.infnet.javawebinfnet.model.Autor;
import com.infnet.javawebinfnet.model.AutorDao;
import com.infnet.javawebinfnet.model.Livro;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Yuri Pereira <yuri.souza@al.infnet.edu.br>
 */
@Controller
@Transactional
public class AutorController {

    @Autowired
    private AutorDao dao;

    @Autowired
    private HttpSession session;

    @RequestMapping("/autores")
    public String autores() {
        this.listarAutores();
        return "autor/index";
    }

    @RequestMapping(value = "/cadastroAutor")
    public String cadastrar() {
        return "autor/cadastro";
    }

    @RequestMapping(value = "/manterAutor")
    public String cadastrar(Autor autor) {
        if (autor.getId() == null) {
            System.out.println("INSERIR");
            dao.inserir(autor);
        } else {
            dao.alterar(autor);
            System.out.println("ALTERAR");
        }
        session.removeAttribute("autores");
        return "redirect:autores";
    }

    private void listarAutores() {
        if (session.getAttribute("autores") == null) {

            List<Autor> autores = dao.listar();

            if (autores != null && !autores.isEmpty()) {
                session.setAttribute("autores", autores);
            }
        }
    }

}
