package com.tsisinskyi.controller.impl;


import com.tsisinskyi.controller.Controller;
import com.tsisinskyi.model.StreetAddress;
import com.tsisinskyi.service.impl.StreetAddressService;

import java.sql.SQLException;
import java.util.List;

public class StreetAddressController implements Controller<StreetAddress> {
    StreetAddressService service = new StreetAddressService();

    @Override
    public List<StreetAddress> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public StreetAddress findByName(String name) throws SQLException {
        return service.findByName(name);
    }

    @Override
    public void create(StreetAddress streetAddress) throws SQLException {
        service.create(streetAddress);
    }

    @Override
    public void update(String name, StreetAddress streetAddress) throws SQLException {
        service.update(name, streetAddress);
    }

    @Override
    public void delete(String name) throws SQLException {
        service.delete(name);
    }
}