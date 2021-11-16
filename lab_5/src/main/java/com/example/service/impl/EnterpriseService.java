package com.example.service.impl;

import com.example.DAO.DAO;
import com.example.DAO.impl.EnterpriseDao;
import com.example.model.Enterprise;
import com.example.service.Service;

import java.sql.SQLException;
import java.util.List;

public class EnterpriseService implements Service<Enterprise> {

    private final DAO<Enterprise> dao = new EnterpriseDao();

    @Override
    public List<Enterprise> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Enterprise findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Enterprise enterprise) throws SQLException {
        dao.create(enterprise);
    }

    @Override
    public void update(Integer id, Enterprise enterprise) throws SQLException {
        dao.update(id, enterprise);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}