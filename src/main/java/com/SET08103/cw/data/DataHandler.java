package com.SET08103.cw.data;

import com.SET08103.cw.objects.City;
import com.SET08103.cw.objects.Country;

import java.sql.*;
import java.util.ArrayList;

/**
 * DataHandler.java
 *
 * This is the class that handles communication with the backend database.
 */
public class DataHandler
{
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
            catch (SQLException | InterruptedException e)
            {
                e.printStackTrace();
            }

            if (connection != null)
                return true;
        }

        return false;
    }

    /**
     * Gets a city record based on its id, usually used to find capital cities from a country record.
     *
     * @param id id to search for
     * @return City record containing city information, or null if not found
     */
    public City getCityFromId(int id)
    {
        try
        {
            PreparedStatement query = connection.prepareStatement("SELECT * FROM city WHERE ID = ?");
            query.setInt(1, id);

            ResultSet results = query.executeQuery();

            results.next();

            City city = new City(
                    results.getInt("ID"),
                    results.getString("Name"),
                    results.getString("CountryCode"),
                    results.getString("District"),
                    results.getLong("Population")
            );

            return city;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Gets a list of all countries in the world.
     *
     * @return ArrayList containing all countries in the world.
     */
    public ArrayList<Country> getCountries()
    {
        ArrayList<Country> countries = new ArrayList<Country>();

        try
        {
            PreparedStatement query = connection.prepareStatement("SELECT * FROM country");
            ResultSet results = query.executeQuery();

            while (results.next())
            {
                Country country = new Country(
                        results.getString("Code"),
                        results.getString("Name"),
                        results.getString("Continent"),
                        results.getString("Region"),
                        results.getLong("Population"),
                        getCityFromId(results.getInt("Capital"))
                );

                countries.add(country);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return countries;
    }
}
