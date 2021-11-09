package com.tsisinskyi.DAO.impl;

import com.tsisinskyi.DAO.DAO;
import com.tsisinskyi.model.City;
import com.tsisinskyi.model.StreetAddress;
import com.tsisinskyi.persistent.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StreetAddressDao implements DAO<StreetAddress> {

    private static final String GET_ALL = "SELECT * FROM mydb.street_address";
    private static final String GET_BY_NAME = "SELECT * FROM mydb.street_address WHERE name=?";
    private static final String CREATE = "INSERT mydb.street_address (`name`) VALUES (?)";
    private static final String UPDATE = "UPDATE mydb.street_address SET name=? WHERE name=?";
    private static final String DELETE = "DELETE FROM mydb.street_address WHERE name=?";

    @Override
    public List<StreetAddress> findAll() throws SQLException {
        List<StreetAddress> streetAddresses = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                StreetAddress streetAddress = new StreetAddress(
                        resultSet.getString("name")
                );
                streetAddresses.add(streetAddress);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return streetAddresses;
    }

    @Override
    public void create(StreetAddress streetAddress) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(streetAddress.getName()));
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public StreetAddress findByName(String name) throws SQLException {
        StreetAddress streetAddress = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_NAME)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                streetAddress = new StreetAddress(
                        resultSet.getString("name")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return streetAddress;
    }

    @Override
    public void update(String name, StreetAddress streetAddress) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, streetAddress.getName());
            statement.setString(2, streetAddress.getName());
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