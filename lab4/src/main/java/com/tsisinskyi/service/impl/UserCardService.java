package com.tsisinskyi.service.impl;

import com.tsisinskyi.DAO.DAO;
import com.tsisinskyi.DAO.impl.UserCardDao;
import com.tsisinskyi.model.UserCard;
import com.tsisinskyi.service.Service;

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