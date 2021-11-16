package com.example.DAO.impl;
import com.example.DAO.DAO;
import com.example.connection.ConnectionManager;
import com.example.model.Enterprise;
import com.example.model.Parking;
import com.example.model.ParkingStory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ParkingStoryDao implements DAO<ParkingStory> {

    protected final SessionFactory sessionFactory = ConnectionManager.getSessionFactory();

    @Override
    public List<ParkingStory> findAll() throws SQLException {
        List<ParkingStory> parkingStories = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            parkingStories = session.createQuery("from ParkingStory ").getResultList();
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return parkingStories;
    }

    @Override
    public ParkingStory findById(Integer id) throws SQLException {
        ParkingStory parkingStory = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            parkingStory = session.get(ParkingStory.class, id);
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return parkingStory;
    }

    @Override
    public void create(ParkingStory parkingStory) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(parkingStory);
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, ParkingStory parkingStory) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(parkingStory);
            session.getTransaction().commit();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            ParkingStory parkingStory = session.get(ParkingStory.class, id);
            if (parkingStory != null) {
                session.delete(parkingStory);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}