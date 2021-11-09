package com.tsisinskyi.controller.impl;

import com.tsisinskyi.controller.Controller;
import com.tsisinskyi.model.Parking;
import com.tsisinskyi.service.Service;
import com.tsisinskyi.service.impl.ParkingService;

import java.sql.SQLException;
import java.util.List;

public class ParkingController implements Controller<Parking> {

    private final Service<Parking> service = new ParkingService();

    @Override
    public List<Parking> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Parking findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Parking parking) throws SQLException {
        service.create(parking);
    }

    @Override
    public void update(Integer id, Parking parking) throws SQLException {
        service.update(id, parking);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
