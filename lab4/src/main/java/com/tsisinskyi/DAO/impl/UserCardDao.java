package com.tsisinskyi.DAO.impl;

import com.tsisinskyi.DAO.DAO;
import com.tsisinskyi.model.ParkingReservation;
import com.tsisinskyi.model.UserCard;
import com.tsisinskyi.persistent.ConnectionManager;

import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserCardDao implements DAO<UserCard> {
    private static final String GET_ALL = "SELECT * FROM mydb.user_card";
    private static final String GET_BY_ID = "SELECT * FROM mydb.user_card WHERE id=?";
    private static final String CREATE = "" +
            "INSERT INTO mydb.user_card " +
            "(name, surname, phone_number, enterprise_id, regular_user) VALUES (?,?,?,?,?);";
    private static final String UPDATE = "" +
            "UPDATE mydb.user_card " +
            "SET `name` = ?, `surname` = ?, `phone_number` = ?, `enterprise_id` = ?, `regular_user` = ? WHERE (`id` = ?);";
    private static final String DELETE = "DELETE FROM mydb.user_card WHERE (`id` = ?);";

    @Override
    public List<UserCard> findAll() throws SQLException {
        List<UserCard> userCardList = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                UserCard userCard = new UserCard(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getLong("phone_number"),
                        resultSet.getInt("enterprise_id"),
                        resultSet.getBoolean("regular_user"));
                userCardList.add(userCard);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return userCardList;
    }

    @Override
    public UserCard findById(Integer id) throws SQLException {
        UserCard userCard = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                userCard = new UserCard(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getLong("phone_number"),
                        resultSet.getInt("enterprise_id"),
                        resultSet.getBoolean("regular_user"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return userCard;
    }

    @Override
    public void create(UserCard userCard) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, userCard.getName());
            statement.setString(2, userCard.getSurname());
            statement.setLong(3, userCard.getPhone_number());
            statement.setInt(4, userCard.getEnterprise_id());
            statement.setBoolean(5, userCard.getRegular_user());
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, UserCard userCard) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, userCard.getName());
            statement.setString(2, userCard.getSurname());
            statement.setLong(3, userCard.getPhone_number());
            statement.setInt(4, userCard.getEnterprise_id());
            statement.setBoolean(5, userCard.getRegular_user());
            statement.setInt(6, userCard.getId());
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