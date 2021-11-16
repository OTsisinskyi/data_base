package com.example.service.impl;

import com.example.DAO.DAO;
import com.example.DAO.impl.UserCardDao;
import com.example.model.UserCard;
import com.example.service.Service;

import java.sql.SQLException;
import java.util.List;

public class UserCardService implements Service<UserCard> {

    private final DAO<UserCard> dao = new UserCardDao();

    @Override
    public List<UserCard> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public UserCard findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(UserCard userCard) throws SQLException {
        dao.create(userCard);
    }

    @Override
    public void update(Integer id, UserCard userCard) throws SQLException {
        dao.update(id, userCard);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}