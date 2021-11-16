package com.example.controller.impl;


import com.example.controller.Controller;
import com.example.model.ParkingStory;
import com.example.service.Service;
import com.example.service.impl.ParkingStoryService;

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