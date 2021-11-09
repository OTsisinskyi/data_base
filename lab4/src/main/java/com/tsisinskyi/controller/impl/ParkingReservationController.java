package com.tsisinskyi.controller.impl;

import com.tsisinskyi.controller.Controller;
import com.tsisinskyi.model.ParkingReservation;
import com.tsisinskyi.service.Service;
import com.tsisinskyi.service.impl.ParkingReservationService;

import java.sql.SQLException;
import java.util.List;

public class ParkingReservationController implements Controller<ParkingReservation> {
    private final Service<ParkingReservation> service = new ParkingReservationService();

    @Override
    public List<ParkingReservation> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public ParkingReservation findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(ParkingReservation parkingReservation) throws SQLException {
        service.create(parkingReservation);
    }

    @Override
    public void update(Integer id, ParkingReservation parkingReservation) throws SQLException {
        service.update(id, parkingReservation);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}