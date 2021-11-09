package com.tsisinskyi.service.impl;

import com.tsisinskyi.DAO.DAO;
import com.tsisinskyi.DAO.impl.ParkingStoryDao;
import com.tsisinskyi.model.ParkingStory;
import com.tsisinskyi.service.Service;

import java.sql.SQLException;
import java.util.List;

public class ParkingStoryService implements Service<ParkingStory> {

    private final DAO<ParkingStory> dao = new ParkingStoryDao();

    @Override
    public List<ParkingStory> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public ParkingStory findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(ParkingStory parkingStory) throws SQLException {
        dao.create(parkingStory);
    }

    @Override
    public void update(Integer id, ParkingStory parkingStory) throws SQLException {
        dao.update(id, parkingStory);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}