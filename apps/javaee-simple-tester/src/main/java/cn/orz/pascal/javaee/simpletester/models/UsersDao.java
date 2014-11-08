/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.javaee.simpletester.models;

import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import cn.orz.pascal.javaee.commons.annotations.ErrorLog;
import cn.orz.pascal.javaee.commons.annotations.TimeLog;

/**
 *
 * @author koduki
 */
@Named
@TimeLog
@ErrorLog
public class UsersDao implements Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    EntityManager em;   

    public void create(Users users) {
        em.persist(users);
    }

    public void edit(Users users) {
        em.merge(users);
    }

    public void destroy(Long id) {
        Users users;
        users = em.getReference(Users.class, id);
        users.getId();

        em.remove(users);
    }

    public List<Users> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Users.class));
        Query q = em.createQuery(cq);

        return q.getResultList();
    }

    public Users get(Long id) {
        return em.find(Users.class, id);
    }

}
