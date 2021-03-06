/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infnet.javawebinfnet.controller;

import com.infnet.javawebinfnet.model.Editora;
import com.infnet.javawebinfnet.model.EditoraDao;
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
public class EditoraController {

    @Autowired
    private EditoraDao dao;

    @Autowired
    private HttpSession session;

    @RequestMapping("/editoras")
    public String editoras() {
        this.listarEditoras();
        return "editora/index";
    }

    @RequestMapping(value = "/cadastroEditora")
    public String cadastrar() {
        session.removeAttribute("editora");
        return "editora/cadastro";
    }

    @RequestMapping(value = "/manterEditora")
    public String manter(Editora editora) {
        if (editora.getId() == null) {
            dao.inserir(editora);
        } else {
            dao.alterar(editora);
        }
        this.limparSessao();
        return "redirect:editoras";
    }

    @RequestMapping(value = "/alterarEditora")
    public String alterar(Long id) {
        this.buscarEditora(id);
        return "editora/cadastro";
    }

    @RequestMapping(value = "/visualizarEditora")
    public String visualizar(Long id) {
        this.buscarEditora(id);
        return "editora/visualizar";
    }

    @RequestMapping(value = "/excluirEditora")
    public String excluir(Long id) {
        Editora editora = dao.buscaPorId(id);
        if (editora != null) {
            dao.excluir(editora);
            this.limparSessao();
        }
        return "redirect:editoras";
    }

    private void listarEditoras() {
        if (session.getAttribute("editoras") == null) {

            List<Editora> editoras = dao.listar();

            if (editoras != null && !editoras.isEmpty()) {
                session.setAttribute("editoras", editoras);
            }
        }
    }

    private void buscarEditora(Long id) {
        Editora editora = dao.buscaPorId(id);
        if (editora != null) {
            session.setAttribute("editora", editora);
        }
    }

    private void limparSessao() {
        session.removeAttribute("editoras");
        session.removeAttribute("livros");
    }

}
