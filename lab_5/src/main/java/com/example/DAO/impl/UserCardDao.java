package com.example.DAO.impl;

import com.example.DAO.DAO;
import com.example.connection.ConnectionManager;
import com.example.model.ParkingStory;
import com.example.model.UserCard;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserCardDao implements DAO<UserCard> {

    protected final SessionFactory sessionFactory = ConnectionManager.getSessionFactory();

    @Override
    public List<UserCard> findAll() throws SQLException {
        List<UserCard> userCardList = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            userCardList = session.createQuery("from UserCard ").getResultList();
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return userCardList;
    }

    @Override
    public UserCard findById(Integer id) throws SQLException {
        UserCard userCard = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            userCard = session.get(UserCard.class, id);
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return userCard;
    }

    @Override
    public void create(UserCard userCard) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(userCard);
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, UserCard userCard) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(userCard);
            session.getTransaction().commit();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            UserCard userCard = session.get(UserCard.class, id);
            if (userCard != null) {
                session.delete(userCard);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}