package com.SET08103.cw.data;

import java.sql.*;

public class DataHandler {
    private String CONNECTION_STRING = "jdbc:mysql://db:3306/world?useSSL=false&allowPublicKeyRetrieval=true";
    private String USER = "root";
    private String PASSWORD = "example";

    private Connection connection;

    /**
     * Attempts to establish a connection with the supplied database.
     *
     * @param retryNumber number of times to attempt the connection
     * @return boolean depending on if connection was successful
     */
    public boolean connect(int retryNumber)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            return false;
        }

        for (int idx = 0; idx < retryNumber; idx++)
        {
            try
            {
                Thread.sleep(1000);
                connection = DriverManager.getConnection(CONNECTION_STRING, USER, PASSWORD);
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        return connection != null;
    }
}
