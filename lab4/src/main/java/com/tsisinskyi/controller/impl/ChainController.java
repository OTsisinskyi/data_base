package com.tsisinskyi.controller.impl;

import com.tsisinskyi.controller.Controller;
import com.tsisinskyi.model.Chain;
import com.tsisinskyi.service.Service;
import com.tsisinskyi.service.impl.ChainService;

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
