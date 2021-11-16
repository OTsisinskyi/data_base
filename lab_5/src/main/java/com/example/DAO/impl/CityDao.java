package com.example.DAO.impl;


import com.example.DAO.DAO;
import com.example.connection.ConnectionManager;
import com.example.model.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDao implements DAO<City> {

    protected final SessionFactory sessionFactory = ConnectionManager.getSessionFactory();

    @Override
    public List<City> findAll() throws SQLException {
        List<City> cities = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            cities = session.createQuery("from City ").getResultList();
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return cities;
    }

    @Override
    public City findByName(String name) throws SQLException {
        City city = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            city = session.get(City.class, name);
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return city;
    }

    @Override
    public void create(City city) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(city);
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void delete(String name) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            City city = session.get(City.class, name);
            if (city != null) {
                session.delete(city);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}