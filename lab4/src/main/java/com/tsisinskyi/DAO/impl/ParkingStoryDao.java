package com.tsisinskyi.DAO.impl;

import com.tsisinskyi.DAO.DAO;
import com.tsisinskyi.model.ParkingStory;
import com.tsisinskyi.model.UserCard;
import com.tsisinskyi.persistent.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParkingStoryDao implements DAO<ParkingStory> {
    private static final String GET_ALL = "SELECT * FROM mydb.parking_story";
    private static final String GET_BY_ID = "SELECT * FROM mydb.parking_story WHERE id=?";
    private static final String CREATE = "" +
            "INSERT INTO mydb.parking_story " +
            "(parking_id, user_card_id, number_car, action , timestamp) VALUES (?,?,?,?,?);";
    private static final String UPDATE = "" +
            "UPDATE mydb.parking_story " +
            "SET `parking_id` = ?, `user_card_id` = ?, `number_car` = ?, `action` = ?, `timestamp` = ? WHERE (`id` = ?);";
    private static final String DELETE = "DELETE FROM mydb.parking_story WHERE (`id` = ?);";

    @Override
    public List<ParkingStory> findAll() throws SQLException {
        List<ParkingStory> parkingStories = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ParkingStory parkingStory = new ParkingStory(
                        resultSet.getInt("id"),
                        resultSet.getInt("parking_id"),
                        resultSet.getInt("user_card_id"),
                        resultSet.getString("number_car"),
                        resultSet.getString("action"),
                        resultSet.getString("timestamp"));
                parkingStories.add(parkingStory);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return parkingStories;
    }

    @Override
    public ParkingStory findById(Integer id) throws SQLException {
        ParkingStory parkingStory = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                parkingStory = new ParkingStory(
                        resultSet.getInt("id"),
                        resultSet.getInt("parking_id"),
                        resultSet.getInt("user_card_id"),
                        resultSet.getString("number_car"),
                        resultSet.getString("action"),
                        resultSet.getString("timestamp"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return parkingStory;
    }

    @Override
    public void create(ParkingStory parkingStory) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setInt(1, parkingStory.getParking_id());
            statement.setInt(2, parkingStory.getUser_card_id());
            statement.setString(3, parkingStory.getNumber_car());
            statement.setString(4, parkingStory.getAction());
            statement.setString(5, parkingStory.getTimestamp());
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, ParkingStory parkingStory) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, parkingStory.getParking_id());
            statement.setInt(2, parkingStory.getUser_card_id());
            statement.setString(3, parkingStory.getNumber_car());
            statement.setString(4, parkingStory.getAction());
            statement.setString(5, parkingStory.getTimestamp());
            statement.setInt(6, parkingStory.getId());
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