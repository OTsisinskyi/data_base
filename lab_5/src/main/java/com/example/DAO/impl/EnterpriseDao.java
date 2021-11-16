package com.example.DAO.impl;


import com.example.DAO.DAO;
import com.example.connection.ConnectionManager;
import com.example.model.Enterprise;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnterpriseDao implements DAO<Enterprise> {

    protected final SessionFactory sessionFactory = ConnectionManager.getSessionFactory();

    @Override
    public List<Enterprise> findAll() throws SQLException {
        List<Enterprise> enterprises = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            enterprises = session.createQuery("from Enterprise ").getResultList();
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return enterprises;
    }

    @Override
    public Enterprise findById(Integer id) throws SQLException {
        Enterprise enterprise = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            enterprise = session.get(Enterprise.class, id);
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return enterprise;
    }

    @Override
    public void create(Enterprise enterprise) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(enterprise);
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Enterprise enterprise) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(enterprise);
            session.getTransaction().commit();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Enterprise enterprise = session.get(Enterprise.class, id);
            if (enterprise != null) {
                session.delete(enterprise);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}