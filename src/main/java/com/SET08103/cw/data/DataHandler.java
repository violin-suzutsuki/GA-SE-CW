package com.SET08103.cw.data;

import com.SET08103.cw.objects.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DataHandler.java
 *
 * This is the class that handles communication with the backend database.
 * It is a singleton that is referenced via DataHandler.getInstance() to prevent inefficient database calls.
 */
public final class DataHandler {
    private static DataHandler INSTANCE;

    /**
     * Gets the class instance, or instantiates it if it does not yet exist.
     *
     * @return DataHandler object
     */
    public static DataHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DataHandler();
        }

        return INSTANCE;
    }

    private String CONNECTION_STRING = "jdbc:mysql://%s/world?useSSL=false&allowPublicKeyRetrieval=true";
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
    public boolean connect(String host, int retryNumber) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            return false;
        }

        for (int idx = 0; idx < retryNumber; idx++) {
            try {
                Thread.sleep(2500);
                connection = DriverManager.getConnection(String.format(CONNECTION_STRING, host), USER, PASSWORD);
            }
            catch (SQLException | InterruptedException e) {
                System.out.println("[-] Unable to connect to SQL database, retrying...");
            }

            if (connection != null) {
                return true;
            }
        }

        return false;
    }

    /**
     * Gets the list of continent objects that are in memory.
     *
     * @return List of continents
     */
    public List<Continent> getContinents() {
        return continents;
    }

    /**
     * Gets a city record based on its id.
     *
     * @param id id to search for
     * @return City record containing city information, or null if not found
     */
    private City getCityFromId(int id) {
        try {
            PreparedStatement query = connection.prepareStatement("SELECT * FROM city WHERE ID = ?");
            query.setInt(1, id);

            ResultSet results = query.executeQuery();

            if (results.next()) {
                City city = new City(
                        results.getInt("ID"),
                        results.getString("Name"),
                        results.getString("CountryCode"),
                        results.getString("District"),
                        results.getLong("Population")
                );

                return city;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Converts the results of an SQL query to an SQL object.
     *
     * @param results ResultSet from SQL query
     * @return Country object
     */
    private Country loadCountryFromResult(ResultSet results) {
        try {
            Country country = new Country(
                    results.getString("Code"),
                    results.getString("Name"),
                    results.getString("Continent"),
                    results.getString("Region"),
                    results.getLong("Population"),
                    getCityFromId(results.getInt("Capital"))
            );

            return country;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Gets a list of all countries in the world.
     *
     * @return List containing all countries in the world.
     */
    private List<Country> getAllCountries() {
        List<Country> countries = new ArrayList<Country>();

        try {
            PreparedStatement query = connection.prepareStatement("SELECT * FROM country");
            ResultSet results = query.executeQuery();

            while (results.next()) {
                Country country = loadCountryFromResult(results);

                if (country != null) {
                    countries.add(country);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return countries;
    }

    /**
     * Get a list of cities in a district.
     *
     * @param district district to search for
     * @return list of cities
     */
    private List<City> getCitiesInDistrict(String district) {
        List<City> cities = new ArrayList<City>();

        try {
            PreparedStatement query = connection.prepareStatement("SELECT * FROM city WHERE District = ?");
            query.setString(1, district);

            ResultSet results = query.executeQuery();

            while (results.next()) {
                City city = new City(
                        results.getInt("ID"),
                        results.getString("Name"),
                        results.getString("CountryCode"),
                        results.getString("District"),
                        results.getLong("Population")
                );

                cities.add(city);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return cities;
    }

    /**
     * Get list of districts in a country
     *
     * @param countryCode country to search for
     * @return List of districts
     */
    private List<District> getDistrictsInCountry(String countryCode) {
        List<District> districts = new ArrayList<District>();

        try {
            PreparedStatement query = connection.prepareStatement("SELECT DISTINCT District FROM city WHERE CountryCode = ?");
            query.setString(1, countryCode);

            ResultSet results = query.executeQuery();

            while (results.next()) {
                String district = results.getString("District");

                District districtObj = new District(district);
                districtObj.addCities(getCitiesInDistrict(district));

                districts.add(districtObj);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return districts;
    }

    /**
     * Searches for all the countries in a given region.
     *
     * @param regionName region name to get countries for
     * @return List containing all countries in a given region
     */
    private List<Country> getCountriesInRegion(String regionName) {
        List<Country> countries = new ArrayList<Country>();

        try {
            PreparedStatement query = connection.prepareStatement("SELECT * FROM country WHERE region = ?");
            query.setString(1, regionName);

            ResultSet results = query.executeQuery();

            while (results.next()) {
                Country country = loadCountryFromResult(results);

                if (country != null) {
                    country.addDistricts(getDistrictsInCountry(country.getCode()));
                    countries.add(country);
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return countries;
    }

    /**
     * Searches for all the regions in a given continent.
     *
     * @param continent continent name to get regions for
     * @return List containing all regions in a given continent
     */
    private List<Region> getRegionsInContinent(String continent) {
        List<Region> regions = new ArrayList<Region>();

        try {
            PreparedStatement query = connection.prepareStatement("SELECT DISTINCT region FROM country WHERE continent = ?");
            query.setString(1, continent);

            ResultSet results = query.executeQuery();

            while (results.next()) {
                String region = results.getString("region");

                Region regionObj = new Region(region);
                regionObj.addCountries(getCountriesInRegion(region));

                regions.add(regionObj);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return regions;
    }

    /**
     * Populates the continents list with continents data from the SQL database
     *
     * @return void
     */
    public void loadContinents() {
        if (continents != null) {
            return;
        }

        continents = new ArrayList<Continent>();

        try {
            PreparedStatement query = connection.prepareStatement("SELECT DISTINCT continent FROM country");
            ResultSet results = query.executeQuery();

            while (results.next()) {
                String continent = results.getString("continent");

                Continent continentObj = new Continent(continent);
                continentObj.addRegions(getRegionsInContinent(continent));

                continents.add(continentObj);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
