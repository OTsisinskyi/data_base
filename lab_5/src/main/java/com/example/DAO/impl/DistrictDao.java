package com.example.DAO.impl;

import com.example.DAO.DAO;
import com.example.connection.ConnectionManager;
import com.example.model.City;
import com.example.model.District;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DistrictDao implements DAO<District> {

    protected final SessionFactory sessionFactory = ConnectionManager.getSessionFactory();

    @Override
    public List<District> findAll() throws SQLException {
        List<District> districts = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            districts = session.createQuery("from District ").getResultList();
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return districts;
    }

    @Override
    public District findByName(String name) throws SQLException {
        District district = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            district = session.get(District.class, name);
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return district;
    }

    @Override
    public void create(District district) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(district);
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void delete(String name) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            District district = session.get(District.class, name);
            if (district != null) {
                session.delete(district);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}