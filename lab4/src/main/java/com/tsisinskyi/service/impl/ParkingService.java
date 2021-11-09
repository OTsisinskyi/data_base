package com.tsisinskyi.service.impl;

import com.tsisinskyi.DAO.DAO;
import com.tsisinskyi.DAO.impl.ParkingDao;
import com.tsisinskyi.model.Parking;
import com.tsisinskyi.service.Service;

import java.sql.SQLException;
import java.util.List;

public class ParkingService implements Service<Parking> {

    private final DAO<Parking> dao = new ParkingDao();

    @Override
    public List<Parking> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Parking findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Parking parking) throws SQLException {
        dao.create(parking);
    }

    @Override
    public void update(Integer id, Parking parking) throws SQLException {
        dao.update(id, parking);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}