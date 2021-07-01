package com.example.borala.demoaula.controllers;

import java.net.URISyntaxException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class conectaBanco {
    static Connection getConnection() throws SQLException, URISyntaxException {
        String dbUri = System.getenv("DATABASE_HOST");
        String dbPort = System.getenv("DATABASE_PORT");
        String dbName = System.getenv("DATABASE_NAME");

        String username = System.getenv("DATABASE_USERNAME");
        String password = System.getenv("DATABASE_PASSWORD");
        String dbUrl = "jdbc:postgresql://" + dbUri + ':' + dbPort + "/" + dbName + "?serverTimezone=UTC";

        return DriverManager.getConnection(dbUrl, username, password);
    }
}