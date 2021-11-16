package com.example.controller.impl;


import com.example.controller.Controller;
import com.example.model.City;
import com.example.service.impl.CityService;

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