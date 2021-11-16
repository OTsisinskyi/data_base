package com.example.DAO.impl;

import com.example.DAO.DAO;
import com.example.connection.ConnectionManager;
import com.example.model.StreetAddress;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StreetAddressDao implements DAO<StreetAddress> {

    protected final SessionFactory sessionFactory = ConnectionManager.getSessionFactory();

    @Override
    public List<StreetAddress> findAll() throws SQLException {
        List<StreetAddress> streetAddresses = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            streetAddresses = session.createQuery("from StreetAddress ").getResultList();
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return streetAddresses;
    }

    @Override
    public StreetAddress findByName(String name) throws SQLException {
        StreetAddress streetAddress = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            streetAddress = session.get(StreetAddress.class, name);
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return streetAddress;
    }

    @Override
    public void create(StreetAddress streetAddress) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(streetAddress);
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void delete(String name) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            StreetAddress streetAddress = session.get(StreetAddress.class, name);
            if (streetAddress != null) {
                session.delete(streetAddress);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}