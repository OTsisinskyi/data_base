package com.example.controller.impl;

import com.example.controller.Controller;
import com.example.model.Chain;
import com.example.service.Service;
import com.example.service.impl.ChainService;

import java.sql.SQLException;
import java.util.List;

public class ChainController implements Controller<Chain> {

    private final Service<Chain> service = new ChainService();

    @Override
    public List<Chain> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Chain findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Chain chain) throws SQLException {
        service.create(chain);
    }

    @Override
    public void update(Integer id, Chain chain) throws SQLException {
        service.update(id, chain);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
