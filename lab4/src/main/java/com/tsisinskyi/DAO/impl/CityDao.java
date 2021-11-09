package com.tsisinskyi.DAO.impl;

import com.tsisinskyi.DAO.DAO;
import com.tsisinskyi.model.City;
import com.tsisinskyi.persistent.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDao implements DAO<City> {

    private static final String GET_ALL = "SELECT * FROM mydb.city";
    private static final String GET_BY_NAME = "SELECT * FROM mydb.city WHERE name=?";
    private static final String CREATE = "INSERT mydb.city (`name`) VALUES (?)";
    private static final String UPDATE = "UPDATE mydb.city SET name=? WHERE name=?";
    private static final String DELETE = "DELETE FROM mydb.city WHERE name=?";

    @Override
    public List<City> findAll() throws SQLException {
        List<City> cities = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                City city = new City(
                        resultSet.getString("name")
                );
                cities.add(city);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }

    @Override
    public void create(City city) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(city.getName()));
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public City findByName(String name) throws SQLException {
        City city = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_NAME)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                city = new City(
                        resultSet.getString("name")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return city;
    }

    @Override
    public void update(String name, City city) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, city.getName());
            statement.setString(2, city.getName());
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