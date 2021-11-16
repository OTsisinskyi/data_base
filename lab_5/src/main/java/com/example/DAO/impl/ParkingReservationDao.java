package com.example.DAO.impl;
import com.example.DAO.DAO;
import com.example.connection.ConnectionManager;
import com.example.model.Enterprise;
import com.example.model.Parking;
import com.example.model.ParkingReservation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParkingReservationDao implements DAO<ParkingReservation> {

    protected final SessionFactory sessionFactory = ConnectionManager.getSessionFactory();

    @Override
    public List<ParkingReservation> findAll() throws SQLException {
        List<ParkingReservation> parkingReservationList = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            parkingReservationList = session.createQuery("from ParkingReservation ").getResultList();
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return parkingReservationList;
    }

    @Override
    public ParkingReservation findById(Integer id) throws SQLException {
        ParkingReservation parkingReservation = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            parkingReservation = session.get(ParkingReservation.class, id);
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return parkingReservation;
    }

    @Override
    public void create(ParkingReservation parkingReservation) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(parkingReservation);
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, ParkingReservation parkingReservation) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(parkingReservation);
            session.getTransaction().commit();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            ParkingReservation parkingReservation = session.get(ParkingReservation.class, id);
            if (parkingReservation != null) {
                session.delete(parkingReservation);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}