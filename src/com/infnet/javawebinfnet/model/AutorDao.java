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
public class AutorDao {

    @PersistenceContext
    private EntityManager manager;

    public Autor buscaPorId(Long id) {
        return manager.find(Autor.class, id);
    }

    public List<Autor> listar() {
        return manager.createQuery("select t from Autor t").getResultList();
    }

    public void inserir(Autor t) {
        manager.persist(t);
    }

    public void alterar(Autor t) {
        manager.merge(t);
    }

    public void excluir(Autor t) {
        Autor autor = buscaPorId(t.getId());
        manager.remove(autor);
    }

    public Autor buscarPorNome(final String nome) throws NoResultException {
        Autor retorno = null;

        retorno = (Autor) manager.createQuery("select t from Autor t WHERE t.nome = :nome")
                .setParameter("nome", nome).getSingleResult();

        return retorno;
    }

}
