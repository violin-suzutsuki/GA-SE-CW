package com.SET08103.cw.data;

import com.SET08103.cw.objects.City;
import com.SET08103.cw.objects.Continent;
import com.SET08103.cw.objects.Country;
import com.SET08103.cw.objects.Region;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    private List<Continent> continents;

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
     * Gets the list of continent objects that are in memory.
     *
     * @return List of continents
     */
    public List<Continent> getContinents()
    {
        return continents;
    }

    /**
     * Gets a city record based on its id.
     *
     * @param id id to search for
     * @return City record containing city information, or null if not found
     */
    private City getCityFromId(int id)
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
     * @return List containing all countries in the world.
     */
    private List<Country> getCountries()
    {
        List<Country> countries = new ArrayList<Country>();

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

    /**
     * Searches the entire country dataset based on a region name, and returns the countries found in that region.
     *
     * @param allCountries all country records in the dataset
     * @param regionName region name to get countries for
     * @return List containing all countries in a given region
     */
    private List<Country> getCountriesInRegion(List<Country> allCountries, String regionName)
    {
        // todo: change this to 2 methods, 1 to get countries in region, 1 to load city data for each country
        List<Country> countries = allCountries.stream().filter(country -> country.getRegion().equals(regionName)).toList();

        for (Country country : countries)
        {
            // country.addCities(getCitiesInCountry());
        }

        return countries;
    }

    private List<Region> getRegionsInContinent(List<Country> allCountries, String continentName)
    {
        // todo: change this to use sql instead of searching the allCountries list
        List<Region> regions = new ArrayList<Region>();

        // mark regions we have already stored
        List<String> markedRegions = new ArrayList<String>();

        for (Country country : allCountries)
        {
            String region = country.getRegion();

            // if region has not been stored, store it and fill it with the relevant countries
            if (!markedRegions.contains(region))
            {
                markedRegions.add(region);

                Region regionObj = new Region(region);
                regionObj.addCountries(getCountriesInRegion(allCountries, region));

                regions.add(regionObj);
            }
        }

        return regions;
    }

    public List<Continent> loadContinents()
    {
        // todo: change this to use sql instead of scuffed search
        List<Continent> continents = new ArrayList<Continent>();
        List<Country> allCountries = getCountries();

        // mark continents we have already stored
        List<String> markedContinents = new ArrayList<String>();

        for (Country country : allCountries)
        {
            String continent = country.getContinent();

            // if continent has not been stored, store it and fill it with the relevant regions
            if (!markedContinents.contains(continent))
            {
                markedContinents.add(continent);

                Continent continentObj = new Continent(continent);
                continentObj.addRegions(getRegionsInContinent(allCountries, continent));

                continents.add(continentObj);
            }
        }

        return continents;
    }
}
