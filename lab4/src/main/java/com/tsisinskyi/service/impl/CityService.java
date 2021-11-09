package com.tsisinskyi.service.impl;

import com.tsisinskyi.DAO.DAO;
import com.tsisinskyi.DAO.impl.CityDao;
import com.tsisinskyi.model.City;
import com.tsisinskyi.service.Service;

import java.sql.SQLException;
import java.util.List;

public class CityService implements Service<City> {

    private final DAO<City> dao = new CityDao();

    @Override
    public List<City> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public City findByName(String name) throws SQLException {
        return dao.findByName(name);
    }

    @Override
    public void create(City city) throws SQLException {
        dao.create(city);
    }

    @Override
    public void update(String name, City city) throws SQLException {
        dao.update(name, city);
    }

    @Override
    public void delete(String name) throws SQLException {
        dao.delete(name);
    }
}