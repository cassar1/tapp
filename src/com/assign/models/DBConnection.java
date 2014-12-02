package com.assign.models;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBConnection {

	private String username;
    private String password;
    private String host;
    private String dbName;
    private Connection dbConnection;

    public DBConnection()
    {
        username = "root";
        password = "";
        host = "localhost:8090";
        dbName = "cps3222";
    }
    public Connection getDbConnection() {
        return dbConnection;
    }

    public void connect()
    {
        String url = "jdbc:mysql://"+host+"/"+dbName;

        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            dbConnection = (Connection) DriverManager.getConnection
                        (url, username, password);
        }
        catch (Exception e)
        {
            e.printStackTrace();
           
        }
    }
    public void disconnect()
    {
        try
        {
            if (dbConnection != null)
                dbConnection.close();
        }
        catch (SQLException e)
        {
            
        }
    }
	
}
