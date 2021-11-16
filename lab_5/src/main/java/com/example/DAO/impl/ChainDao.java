package com.example.DAO.impl;

import com.example.DAO.DAO;
import com.example.connection.ConnectionManager;
import com.example.model.Chain;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChainDao implements DAO<Chain> {

    protected final SessionFactory sessionFactory = ConnectionManager.getSessionFactory();

    @Override
    public List<Chain> findAll() throws SQLException {
        List<Chain> chains = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            chains = session.createQuery("from Chain ").getResultList();
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return chains;
    }

    @Override
    public Chain findById(Integer id) throws SQLException {
        Chain chain = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            chain = session.get(Chain.class, id);
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return chain;
    }

    @Override
    public void create(Chain chain) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(chain);
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Chain chain) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(chain);
            session.getTransaction().commit();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Chain chain = session.get(Chain.class, id);
            if (chain != null) {
                session.delete(chain);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
