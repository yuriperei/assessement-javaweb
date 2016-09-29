/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infnet.javawebinfnet.controller;

import com.infnet.javawebinfnet.model.Livro;
import com.infnet.javawebinfnet.model.LivroDao;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Yuri Pereira <yuri.souza@al.infnet.edu.br>
 */
@RestController
@Transactional
public class LivroWSController {

    @Autowired
    private LivroDao dao;

    @GetMapping("/livrosWS")
    public List<Livro> getLivros() {
        return (List<Livro>) dao.listar();
    }

    @GetMapping("/livroWS/{id}")
    public ResponseEntity getLivro(@PathVariable("id") Long id) {

        Livro livro = dao.buscaPorId(id);
        if (livro == null) {
            return new ResponseEntity("Nenhum livro encontrado com o ID " + id, HttpStatus.NOT_FOUND);
        } 

        return new ResponseEntity(livro, HttpStatus.OK);
    }

    @PostMapping(value = "/livroWS")
    public ResponseEntity inserirLivro(@RequestBody Livro livro) {

        if(livro!=null){
            dao.inserir(livro);
            return new ResponseEntity(livro, HttpStatus.CREATED);
        }
        
        else return new ResponseEntity(livro, HttpStatus.BAD_REQUEST);

        
    }
}
