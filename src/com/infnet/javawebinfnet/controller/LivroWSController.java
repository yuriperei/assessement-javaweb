/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infnet.javawebinfnet.controller;

import com.infnet.javawebinfnet.model.Livro;
import com.infnet.javawebinfnet.model.LivroDao;
import java.util.List;
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
public class LivroWSController {

    @Autowired
    private LivroDao dao;

    @GetMapping("/livrosWS")
    public List<Livro> getCustomers() {
        return (List<Livro>) dao.listar();
    }

    @GetMapping("/livroWS/{id}")
    public ResponseEntity getCustomer(@PathVariable("id") Long id) {

        Livro livro = dao.buscaPorId(id);
        if (livro == null) {
            return new ResponseEntity("No Book found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(livro, HttpStatus.OK);
    }

    @PostMapping(value = "/livrosWSS")
    public ResponseEntity createCustomer(@RequestBody Livro livro) {

        dao.inserir(livro);

        return new ResponseEntity(livro, HttpStatus.OK);
    }
}
