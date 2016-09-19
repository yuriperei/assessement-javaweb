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
public class EditoraDao {

    @PersistenceContext
    private EntityManager manager;

    public Editora buscaPorId(Long id) {
        return manager.find(Editora.class, id);
    }

    public List<Editora> listar() {
        return manager.createQuery("select t from Editora t").getResultList();
    }

    public void inserir(Editora t) {
        manager.persist(t);
    }

    public void alterar(Editora t) {
        manager.merge(t);
    }

    public void excluir(Editora t) {
        Editora editora = buscaPorId(t.getId());
        manager.remove(editora);
    }

    public Editora buscarPorTitulo(final String editora) throws NoResultException {
        Editora retorno = null;

        retorno = (Editora) manager.createQuery("select t from Editora t WHERE t.editora = :editora")
                .setParameter("editora", editora).getSingleResult();

        return retorno;
    }

}
