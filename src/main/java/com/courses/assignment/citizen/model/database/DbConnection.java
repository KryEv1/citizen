package com.courses.assignment.citizen.model.database;

import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;

@NoArgsConstructor
public class DbConnection {
    private static DbConnection instance;

    private static final String url = "jdbc:mysql://localhost:3306/citizen_db";
    private static final String user = "root";
    private static final String password = "root";

    public static DbConnection getInstance() {
        if (instance == null) {
            instance = new DbConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
