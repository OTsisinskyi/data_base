package com.example.service.impl;


import com.example.DAO.DAO;
import com.example.DAO.impl.StreetAddressDao;
import com.example.model.StreetAddress;
import com.example.service.Service;

import java.sql.SQLException;
import java.util.List;

public class StreetAddressService implements Service<StreetAddress> {

    private final DAO<StreetAddress> dao = new StreetAddressDao();

    @Override
    public List<StreetAddress> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public StreetAddress findByName(String name) throws SQLException {
        return dao.findByName(name);
    }

    @Override
    public void create(StreetAddress streetAddress) throws SQLException {
        dao.create(streetAddress);
    }

    @Override
    public void update(String name, StreetAddress streetAddress) throws SQLException {
        dao.update(name, streetAddress);
    }

    @Override
    public void delete(String name) throws SQLException {
        dao.delete(name);
    }
}