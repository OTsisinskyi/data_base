package com.tsisinskyi.service.impl;

import com.tsisinskyi.DAO.DAO;
import com.tsisinskyi.DAO.impl.DistrictDao;
import com.tsisinskyi.model.District;
import com.tsisinskyi.service.Service;

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