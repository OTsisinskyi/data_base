package com.tsisinskyi.DAO.impl;

import com.tsisinskyi.DAO.DAO;
import com.tsisinskyi.model.ParkingReservation;
import com.tsisinskyi.persistent.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParkingReservationDao implements DAO<ParkingReservation> {
    private static final String GET_ALL = "SELECT * FROM mydb.parking_reservation";
    private static final String GET_BY_ID = "SELECT * FROM mydb.parking_reservation WHERE id=?";
    private static final String CREATE = "" +
            "INSERT INTO mydb.parking_reservation " +
            "(car_number, time, parking_id) VALUES (?,?,?);";
    private static final String UPDATE = "" +
            "UPDATE mydb.parking_reservation " +
            "SET `car_number` = ?, `time` = ?, `parking_id` = ? WHERE (`id` = ?);";
    private static final String DELETE = "DELETE FROM mydb.parking_reservation WHERE (`id` = ?);";

    @Override
    public List<ParkingReservation> findAll() throws SQLException {
        List<ParkingReservation> parkingReservationList = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ParkingReservation parkingReservation = new ParkingReservation(
                        resultSet.getInt("id"),
                        resultSet.getString("car_number"),
                        resultSet.getString("time"),
                        resultSet.getInt("parking_id"));
                parkingReservationList.add(parkingReservation);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return parkingReservationList;
    }

    @Override
    public ParkingReservation findById(Integer id) throws SQLException {
        ParkingReservation parkingReservation = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                parkingReservation = new ParkingReservation(
                        resultSet.getInt("id"),
                        resultSet.getString("car_number"),
                        resultSet.getString("time"),
                        resultSet.getInt("parking_id"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return parkingReservation;
    }

    @Override
    public void create(ParkingReservation parkingReservation) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, parkingReservation.getCar_number());
            statement.setString(2, parkingReservation.getTime());
            statement.setInt(3, parkingReservation.getParking_id());
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, ParkingReservation parkingReservation) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, parkingReservation.getCar_number());
            statement.setString(2, parkingReservation.getTime());
            statement.setInt(3, parkingReservation.getParking_id());
            statement.setInt(4, parkingReservation.getId());
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