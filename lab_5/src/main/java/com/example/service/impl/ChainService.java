package com.example.service.impl;

import com.example.DAO.DAO;
import com.example.DAO.impl.ChainDao;
import com.example.model.Chain;
import com.example.service.Service;

import java.sql.SQLException;
import java.util.List;

public class ChainService implements Service<Chain> {

    private final DAO<Chain> dao = new ChainDao();

    @Override
    public List<Chain> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Chain findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Chain chain) throws SQLException {
        dao.create(chain);
    }

    @Override
    public void update(Integer id, Chain chain) throws SQLException {
        dao.update(id, chain);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}