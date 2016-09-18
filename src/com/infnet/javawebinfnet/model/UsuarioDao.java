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
public class UsuarioDao {

    @PersistenceContext
    private EntityManager manager;

    public Usuario buscaPorId(Long id) {
        return manager.find(Usuario.class, id);
    }

    public List<Usuario> listar() {
        return manager.createQuery("select t from Usuario t").getResultList();
    }

    public void inserir(Usuario t) {
        manager.persist(t);
    }

    public void alterar(Usuario t) {
        manager.merge(t);
    }

    public void excluir(Usuario t) {
        Usuario usuario = buscaPorId(t.getId());
        manager.remove(usuario);
    }

    public Usuario buscarPorEmail(final String email) throws NoResultException {
        Usuario retorno = null;

        retorno = (Usuario) manager.createQuery("select t from Usuario t WHERE t.email = :email")
                .setParameter("email", email).getSingleResult();

        return retorno;
    }

}
