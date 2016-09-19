/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infnet.javawebinfnet.controller;

import com.infnet.javawebinfnet.model.Autor;
import com.infnet.javawebinfnet.model.AutorDao;
import com.infnet.javawebinfnet.model.Editora;
import com.infnet.javawebinfnet.model.EditoraDao;
import com.infnet.javawebinfnet.model.Livro;
import com.infnet.javawebinfnet.model.LivroDao;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Yuri Pereira <yuri.souza@al.infnet.edu.br>
 */
@Controller
public class LivroController {

    @Autowired
    private LivroDao dao;

    @Autowired
    private AutorDao autorDao;

    @Autowired
    private EditoraDao editoraDao;

    @Autowired
    private HttpSession session;

    @RequestMapping("/livros")
    public String livros() {
        this.listarLivros();
        return "livro/index";
    }

    @RequestMapping(value = "/cadastroLivro", method = RequestMethod.GET)
    public String cadastrar() {
        this.listarAutores();
        this.listarEditoras();
        return "livro/cadastro";
    }

    @RequestMapping(value = "/cadastroLivro", method = RequestMethod.POST)
    public String cadastrar(Livro livro) {
        
        
        
        return "redirect:livros";
    }

    private void listarAutores() {
        if (session.getAttribute("autores") == null) {

            List<Autor> autores = autorDao.listar();

            if (autores != null && !autores.isEmpty()) {
                session.setAttribute("autores", autores);
            }
        }
    }

    private void listarEditoras() {
        if (session.getAttribute("editoras") == null) {

            List<Editora> editoras = editoraDao.listar();
            if (editoras != null && !editoras.isEmpty()) {
                session.setAttribute("editoras", editoras);
            }
        }
    }

    private void listarLivros() {
        if (session.getAttribute("livros") == null) {

            List<Livro> livros = dao.listar();

            if (livros != null && !livros.isEmpty()) {
                session.setAttribute("livros", livros);
            }
        }
    }

}
