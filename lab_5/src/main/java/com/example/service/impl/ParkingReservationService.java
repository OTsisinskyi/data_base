package com.example.service.impl;

import com.example.DAO.DAO;
import com.example.DAO.impl.ParkingReservationDao;
import com.example.model.ParkingReservation;
import com.example.service.Service;

import java.sql.SQLException;
import java.util.List;

public class ParkingReservationService implements Service<ParkingReservation> {

    private final DAO<ParkingReservation> dao = new ParkingReservationDao();

    @Override
    public List<ParkingReservation> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public ParkingReservation findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(ParkingReservation parkingReservation) throws SQLException {
        dao.create(parkingReservation);
    }

    @Override
    public void update(Integer id, ParkingReservation parkingReservation) throws SQLException {
        dao.update(id, parkingReservation);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}