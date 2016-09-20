/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infnet.javawebinfnet.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DesenvolvedorJava
 */
@Repository
public class LivroDao {

    @PersistenceContext
    private EntityManager manager;

    public Livro buscaPorId(Long id) {
        return manager.find(Livro.class, id);
    }

    public List<Livro> listar() {
        return manager.createQuery("select t from Livro t").getResultList();
    }

    public void inserir(Livro t) {
        manager.persist(t);
    }

    public void alterar(Livro t) {
        manager.merge(t);
    }

    public void excluir(Livro t) {
        manager.remove(t);
    }

    public Livro buscarPorTitulo(final String titulo) throws NoResultException {
        Livro retorno = null;

        retorno = (Livro) manager.createQuery("select t from Livro t WHERE t.titulo = :titulo")
                .setParameter("titulo", titulo).getSingleResult();

        return retorno;
    }

}
