package com.tsisinskyi.DAO.impl;

import com.tsisinskyi.DAO.DAO;
import com.tsisinskyi.model.Chain;
import com.tsisinskyi.persistent.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChainDao implements DAO<Chain> {
    private static final String GET_ALL = "SELECT * FROM mydb.chain";
    private static final String GET_BY_ID = "SELECT * FROM mydb.chain WHERE id=?";
    private static final String CREATE = "INSERT INTO mydb.chain (name) VALUES (?);";
    private static final String UPDATE = "UPDATE mydb.chain SET `name` = ? WHERE (`id` = ?);";
    private static final String DELETE = "DELETE FROM mydb.chain WHERE (`id` = ?);";

    @Override
    public List<Chain> findAll() throws SQLException {
        List<Chain> chains = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Chain chain = new Chain(
                        resultSet.getInt("id"),
                        resultSet.getString("name"));
                chains.add(chain);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return chains;
    }

    @Override
    public Chain findById(Integer id) throws SQLException {
        Chain chain = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                chain = new Chain(
                        resultSet.getInt("id"),
                        resultSet.getString("name"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return chain;
    }

    @Override
    public void create(Chain chain) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, chain.getName());
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Chain chain) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, chain.getName());
            statement.setInt(2, chain.getId());
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
