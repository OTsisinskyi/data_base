package com.tsisinskyi.controller.impl;


import com.tsisinskyi.controller.Controller;
import com.tsisinskyi.model.ParkingStory;
import com.tsisinskyi.service.Service;
import com.tsisinskyi.service.impl.ParkingStoryService;

import java.sql.SQLException;
import java.util.List;

public class ParkingStoryController implements Controller<ParkingStory> {
    private final Service<ParkingStory> service = new ParkingStoryService();

    @Override
    public List<ParkingStory> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public ParkingStory findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(ParkingStory parkingStory) throws SQLException {
        service.create(parkingStory);
    }

    @Override
    public void update(Integer id, ParkingStory parkingStory) throws SQLException {
        service.update(id, parkingStory);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}