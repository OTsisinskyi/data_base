package com.tsisinskyi.controller.impl;


import com.tsisinskyi.controller.Controller;
import com.tsisinskyi.model.City;
import com.tsisinskyi.service.impl.CityService;

import java.sql.SQLException;
import java.util.List;

public class CityController implements Controller<City> {
    CityService service = new CityService();

    @Override
    public List<City> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public void create(City entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public City findByName(String name) throws SQLException {
        return service.findByName(name);
    }

    @Override
    public void update(String name, City entity) throws SQLException {
        service.update(name, entity);
    }

    @Override
    public void delete(String name) throws SQLException {
        service.delete(name);
    }

}