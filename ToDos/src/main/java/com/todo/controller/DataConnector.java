package com.todo.controller;

import com.todo.model.List;
import com.todo.model.Task;

import java.sql.*;


public class DataConnector {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test";
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private Connection connect = null;
    private Statement statement = null;

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";

    public List readData() throws SQLException, ClassNotFoundException {
        List list = new List();
        Class.forName(JDBC_DRIVER);
        System.out.println("Connecting to database...");
        connect = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Connected database successfully...");
        statement = connect.createStatement();
        String sql = "SELECT * FROM TodoList";
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Task task = new Task(resultSet.getString("content"), resultSet.getString("state"));
            list.add(task);
        }
        resultSet.close();
        return list;
    }

    public void writeData(List list) throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        System.out.println("Connecting to database...");
        connect = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Connected database successfully...");
        String sql = "DELETE FROM TodoList";
        preparedStatement = connect.prepareStatement(sql);
        preparedStatement.executeUpdate();
        for (Task task : list) {
            sql = "INSERT INTO TodoList (content, state) " + "VALUES(\'" + task.getContent() + "\', \'" + task.getState() + "\')";
            System.out.println(sql);
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.executeUpdate();
        }
    }
}