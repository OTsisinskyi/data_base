package com.tsisinskyi.controller.impl;

import com.tsisinskyi.controller.Controller;
import com.tsisinskyi.model.Enterprise;
import com.tsisinskyi.service.Service;
import com.tsisinskyi.service.impl.EnterpriseService;

import java.sql.SQLException;
import java.util.List;

public class EnterpriseController implements Controller<Enterprise> {

    private final Service<Enterprise> service = new EnterpriseService();

    @Override
    public List<Enterprise> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Enterprise findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Enterprise enterprise) throws SQLException {
        service.create(enterprise);
    }

    @Override
    public void update(Integer id, Enterprise enterprise) throws SQLException {
        service.update(id, enterprise);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
