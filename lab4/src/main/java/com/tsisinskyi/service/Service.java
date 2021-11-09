package com.tsisinskyi.service;

import java.sql.SQLException;
import java.util.List;

public interface Service<T> {
    List<T> findAll() throws SQLException;

    default T findById(Integer id) throws SQLException {
        return null;
    }

    default void create(T entity) throws SQLException {
    }

    default void update(Integer id, T entity) throws SQLException {
    }

    default void delete(Integer id) throws SQLException {
    }

    default T findByName(String name) throws SQLException {
        return null;
    }

    default void update(String name, T entity) throws SQLException {
    }

    default void delete(String name) throws SQLException {
    }
}