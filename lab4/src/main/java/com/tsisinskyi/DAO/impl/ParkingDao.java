package com.tsisinskyi.DAO.impl;

import com.tsisinskyi.DAO.DAO;
import com.tsisinskyi.model.Parking;
import com.tsisinskyi.persistent.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParkingDao implements DAO<Parking> {
    private static final String GET_ALL = "SELECT * FROM mydb.parking";
    private static final String GET_BY_ID = "SELECT * FROM mydb.parking WHERE id=?";
    private static final String CREATE = "" +
            "INSERT INTO mydb.parking " +
            "(total_number, price_per_hour, street_address_name, district_name, city_name, chain_id) VALUES (?,?,?,?,?,?);";
    private static final String UPDATE = "" +
            "UPDATE mydb.parking " +
            "SET `total_number` = ?, `price_per_hour` = ?, `street_address_name` = ?, `district_name` = ?, `city_name` = ?, `chain_id` = ? WHERE (`id` = ?);";
    private static final String DELETE = "DELETE FROM mydb.parking WHERE (`id` = ?);";

    @Override
    public List<Parking> findAll() throws SQLException {
        List<Parking> parkings = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Parking parking = new Parking(
                        resultSet.getInt("id"),
                        resultSet.getInt("total_number"),
                        resultSet.getInt("price_per_hour"),
                        resultSet.getString("street_address_name"),
                        resultSet.getString("district_name"),
                        resultSet.getString("city_name"),
                        resultSet.getInt("chain_id"));
                parkings.add(parking);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return parkings;
    }

    @Override
    public Parking findById(Integer id) throws SQLException {
        Parking parking = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                parking = new Parking(
                        resultSet.getInt("id"),
                        resultSet.getInt("total_number"),
                        resultSet.getInt("price_per_hour"),
                        resultSet.getString("street_address_name"),
                        resultSet.getString("district_name"),
                        resultSet.getString("city_name"),
                        resultSet.getInt("chain_id"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return parking;
    }

    @Override
    public void create(Parking parking) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setInt(1, parking.getTotal_number());
            statement.setInt(2, parking.getPrice_per_hour());
            statement.setString(3, parking.getStreet_address_name());
            statement.setString(4, parking.getDistrict_name());
            statement.setString(5, parking.getCity_name());
            statement.setInt(6, parking.getChain_id());
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Parking parking) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, parking.getTotal_number());
            statement.setInt(2, parking.getPrice_per_hour());
            statement.setString(3, parking.getStreet_address_name());
            statement.setString(4, parking.getDistrict_name());
            statement.setString(5, parking.getCity_name());
            statement.setInt(6, parking.getChain_id());
            statement.setInt(7, parking.getId());
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