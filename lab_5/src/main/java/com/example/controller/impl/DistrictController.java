package com.example.controller.impl;

import com.example.controller.Controller;
import com.example.model.District;
import com.example.service.impl.DistrictService;

import java.sql.SQLException;
import java.util.List;

public class DistrictController implements Controller<District> {
    DistrictService service = new DistrictService();

    @Override
    public List<District> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public void create(District entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public District findByName(String name) throws SQLException {
        return service.findByName(name);
    }

    @Override
    public void update(String name, District entity) throws SQLException {
        service.update(name, entity);
    }

    @Override
    public void delete(String name) throws SQLException {
        service.delete(name);
    }

}