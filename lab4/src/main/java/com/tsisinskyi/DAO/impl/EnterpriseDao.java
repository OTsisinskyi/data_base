package com.tsisinskyi.DAO.impl;

import com.tsisinskyi.DAO.DAO;
import com.tsisinskyi.model.Enterprise;
import com.tsisinskyi.persistent.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnterpriseDao implements DAO<Enterprise> {
    private static final String GET_ALL = "SELECT * FROM mydb.enterprise";
    private static final String GET_BY_ID = "SELECT * FROM mydb.enterprise WHERE id=?";
    private static final String CREATE = "INSERT INTO mydb.enterprise (name) VALUES (?);";
    private static final String UPDATE = "UPDATE mydb.enterprise SET `name` = ? WHERE (`id` = ?);";
    private static final String DELETE = "DELETE FROM mydb.enterprise WHERE (`id` = ?);";

    @Override
    public List<Enterprise> findAll() throws SQLException {
        List<Enterprise> enterprises = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Enterprise enterprise = new Enterprise(
                        resultSet.getInt("id"),
                        resultSet.getString("name"));
                enterprises.add(enterprise);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return enterprises;
    }

    @Override
    public Enterprise findById(Integer id) throws SQLException {
        Enterprise enterprise = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                enterprise = new Enterprise(
                        resultSet.getInt("id"),
                        resultSet.getString("name"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return enterprise;
    }

    @Override
    public void create(Enterprise enterprise) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, enterprise.getName());
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Enterprise enterprise) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, enterprise.getName());
            statement.setInt(2, enterprise.getId());
            statement.executeUpdate();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
