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
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Yuri Pereira <yuri.souza@al.infnet.edu.br>
 */
@Controller
@Transactional
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
        //session.removeAttribute("livros");
        this.listarLivros();
        return "livro/index";
    }

    @RequestMapping(value = "/cadastroLivro")
    public String cadastrar() {
        session.removeAttribute("livro");
        this.listarAutores();
        this.listarEditoras();
        return "livro/cadastro";
    }

    @RequestMapping(value = "/manterLivro")
    public String manter(Livro livro) {

        if (livro.getId() == null) {
            dao.inserir(livro);
        } else {
            dao.alterar(livro);
        }

        session.removeAttribute("livros");
        return "redirect:livros";
    }

    @RequestMapping(value = "/alterarLivro")
    public String alterar(Long id) {
        this.buscarLivro(id);
        this.listarAutores();
        this.listarEditoras();
        return "livro/cadastro";
    }

    @RequestMapping(value = "/visualizarLivro")
    public String visualizar(Long id) {
        this.buscarLivro(id);
        return "livro/visualizar";
    }

    @RequestMapping(value = "/excluirLivro")
    public String excluir(Long id) {
        Livro livro = dao.buscaPorId(id);
        if (livro != null) {
            dao.excluir(livro);
            session.removeAttribute("livros");
        }
        return "redirect:livros";
    }

    private void buscarLivro(Long id) {
        Livro livro = dao.buscaPorId(id);
        if (livro != null) {
            session.setAttribute("livro", livro);
        }
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
