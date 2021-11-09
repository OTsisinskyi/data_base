package com.tsisinskyi.DAO.impl;

import com.tsisinskyi.DAO.DAO;
import com.tsisinskyi.model.District;
import com.tsisinskyi.persistent.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DistrictDao implements DAO<District> {

    private static final String GET_ALL = "SELECT * FROM mydb.district";
    private static final String GET_BY_NAME = "SELECT * FROM mydb.district WHERE name=?";
    private static final String CREATE = "INSERT mydb.district (`name`) VALUES (?)";
    private static final String UPDATE = "UPDATE mydb.district SET name=? WHERE name=?";
    private static final String DELETE = "DELETE FROM mydb.district WHERE name=?";

    @Override
    public List<District> findAll() throws SQLException {
        List<District> districts = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                District district = new District(
                        resultSet.getString("name")
                );
                districts.add(district);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return districts;
    }

    @Override
    public void create(District district) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(district.getName()));
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public District findByName(String name) throws SQLException {
        District district = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_NAME)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                district = new District(
                        resultSet.getString("name")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return district;
    }

    @Override
    public void update(String name, District district) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, district.getName());
            statement.setString(2, district.getName());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String name) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}