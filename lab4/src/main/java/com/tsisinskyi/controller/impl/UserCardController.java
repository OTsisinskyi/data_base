package com.tsisinskyi.controller.impl;

import com.tsisinskyi.controller.Controller;

import com.tsisinskyi.model.UserCard;
import com.tsisinskyi.service.Service;
import com.tsisinskyi.service.impl.UserCardService;

import java.sql.SQLException;
import java.util.List;

public class UserCardController implements Controller<UserCard> {

    private final Service<UserCard> service = new UserCardService();

    @Override
    public List<UserCard> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public UserCard findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(UserCard userCard) throws SQLException {
        service.create(userCard);
    }

    @Override
    public void update(Integer id, UserCard userCard) throws SQLException {
        service.update(id, userCard);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
