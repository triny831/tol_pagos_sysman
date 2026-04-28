package com.tol.pagos.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {

    public static Connection getConnection() throws Exception {

        Properties props = new Properties();

        InputStream input = DBConnection.class
                .getClassLoader()
                .getResourceAsStream("db.properties");

        props.load(input);

        Class.forName(props.getProperty("db.driver"));

        return DriverManager.getConnection(
                props.getProperty("db.url"),
                props.getProperty("db.user"),
                props.getProperty("db.password")
        );
    }
}
