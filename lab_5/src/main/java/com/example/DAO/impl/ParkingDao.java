package com.example.DAO.impl;


import com.example.DAO.DAO;
import com.example.connection.ConnectionManager;
import com.example.model.Enterprise;
import com.example.model.Parking;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParkingDao implements DAO<Parking> {

    protected final SessionFactory sessionFactory = ConnectionManager.getSessionFactory();

    @Override
    public List<Parking> findAll() throws SQLException {
        List<Parking> parkings = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            parkings = session.createQuery("from Parking ").getResultList();
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return parkings;
    }

    @Override
    public Parking findById(Integer id) throws SQLException {
        Parking parking = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            parking = session.get(Parking.class, id);
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return parking;
    }

    @Override
    public void create(Parking parking) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(parking);
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Parking parking) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(parking);
            session.getTransaction().commit();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Parking parking = session.get(Parking.class, id);
            if (parking != null) {
                session.delete(parking);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}