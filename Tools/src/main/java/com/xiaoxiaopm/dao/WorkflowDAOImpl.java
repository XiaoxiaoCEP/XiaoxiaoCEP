package com.xiaoxiaopm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xiaoxiaopm.model.Workflow;

public class WorkflowDAOImpl implements WorkflowDAO {
    
    private SessionFactory sessionFactory;
    
    @SuppressWarnings("unused")
    private void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Workflow workflow) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(workflow);
        tx.commit();
        session.close();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Workflow> list() {
        Session session = this.sessionFactory.openSession();
        List<Workflow> personList = session.createQuery("from Person").list();
        session.close();
        return personList;
    }

}
