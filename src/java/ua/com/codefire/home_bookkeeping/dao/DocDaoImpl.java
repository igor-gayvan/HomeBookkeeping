/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.home_bookkeeping.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import ua.com.codefire.home_bookkeeping.dao.models.Doc;

/**
 *
 * @author Igor Gayvan
 */
public class DocDaoImpl implements IDocDao {

    private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("HomeBookkeepingPU");

    private EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    @Override
    public List<Doc> getAll() {
        EntityManager em = getEntityManager();
        List<Doc> list = em.createNamedQuery("Doc.findAll", Doc.class).getResultList();
        em.close();
        return list;
    }

    @Override
    public List<Doc> getByDocNote(String docNote) {
        EntityManager em = getEntityManager();
        List<Doc> list = em.createNamedQuery("Doc.findByDocNote", Doc.class).setParameter("docNote", docNote).getResultList();
        em.close();
        return list;
    }

    @Override
    public Doc getByDocId(int id) {
        EntityManager em = getEntityManager();
        Doc doc = em.createNamedQuery("Doc.findByDocId", Doc.class).setParameter("docId", id).getSingleResult();
        em.close();
        return doc;
    }

    @Override
    public void add(Doc doc) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(doc);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void remove(int id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Doc finded = em.find(Doc.class, id);
        em.remove(finded);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void edit(Doc doc) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Doc foundDoc = em.find(Doc.class, doc.getDocId());
        foundDoc.setDocAmount(doc.getDocAmount());
        foundDoc.setDocDate(doc.getDocDate());
        foundDoc.setDocNote(doc.getDocNote());
        foundDoc.setIsIncome(doc.getIsIncome());
        em.getTransaction().commit();
        em.close();
    }
}
