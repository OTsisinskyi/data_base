package com.example.service.impl;

import com.example.DAO.DAO;
import com.example.DAO.impl.DistrictDao;
import com.example.model.District;
import com.example.service.Service;

import java.sql.SQLException;
import java.util.List;

public class DistrictService implements Service<District> {

    private final DAO<District> dao = new DistrictDao();

    @Override
    public List<District> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public District findByName(String name) throws SQLException {
        return dao.findByName(name);
    }

    @Override
    public void create(District district) throws SQLException {
        dao.create(district);
    }

    @Override
    public void update(String name, District district) throws SQLException {
        dao.update(name, district);
    }

    @Override
    public void delete(String name) throws SQLException {
        dao.delete(name);
    }
}