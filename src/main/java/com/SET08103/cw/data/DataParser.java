package com.SET08103.cw.data;

import com.SET08103.cw.objects.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.ArrayList;
import java.util.List;

/**
 * DataParser.java
 *
 * Wrapper class that communicates with the DataHandler.
 */
public final class DataParser {
    /**
     * Parses any java object into a json string.
     *
     * @param object the object to serialize
     * @return a json string, empty if there was a serialization error
     */
    public static String toJson(Object object) {
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

        String json;

        try {
            json = objectWriter.writeValueAsString(object);
        }
        catch(Exception e) {
            return "{}";
        }

        return json;
    }

    /**
     * fromJson class using generics so that a developer can specify the type of list to return.
     * Without specifying the type, the ObjectMapper class is not able to understand how to map readValue to the List
     *
     * @param json to decode
     * @param classType class to decode to (i.e. Country.class)
     * @return list of memory instantiated objects
     */
    public static <T> List<T> fromJson(String json, Class<T> classType) {
        ObjectMapper objectMapper = new ObjectMapper();
        CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, classType);

        List<T> ret = null;

        try {
            ret = objectMapper.readValue(json, listType);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ret;
    }

    /**
     * DataHandler wrapper to get all of the world's continents
     *
     * @return a list of continents.
     */
    public static List<Continent> getContinents() {
        return DataHandler.getInstance().getContinents();
    }

    /**
     * Get all of the countries in the world.
     *
     * @return a list of countries
     */
    public static List<Country> getCountriesInWorld() {
        List<Continent> continents = getContinents();
        List<Country> countries = new ArrayList<Country>();

        for (Continent continent : continents) {
            for (Region region : continent.getRegions()) {
                countries.addAll(region.getCountries());
            }
        }

        return countries;
    }

    /**
     * Get all of the countries in a continent sorted by population in descending order
     *
     * @param continentName continent name to search for, non caps-sensitive
     * @return a list of countries
     */
    public static List<Country> getCountriesInContinent(String continentName) {
        List<Country> countries = new ArrayList<Country>();

        for (Country country : getCountriesInWorld()) {
            if (country.getContinent().toLowerCase().contains(continentName.toLowerCase())) {
                countries.add(country);
            }
        }

        return countries;
    }

    /**
     * Get all of the countries in a region sorted by population in descending order
     *
     * @param regionName region name to search for, non caps-sensitive
     * @return a list of countries
     */
    public static List<Country> getCountriesInRegion(String regionName) {
        List<Country> countries = new ArrayList<Country>();

        for (Country country : getCountriesInWorld()) {
            if (country.getRegion().toLowerCase().contains(regionName.toLowerCase())) {
                countries.add(country);
            }
        }

        return countries;
    }

    /**
     * Get all of the cities in the world.
     *
     * @return a list of cities
     */
    public static List<City> getCitiesInWorld() {
        List<Continent> continents = getContinents();
        List<City> cities = new ArrayList<City>();

        for (Continent continent : continents) {
            for (Region region : continent.getRegions()) {
                for (Country country : region.getCountries()) {
                    for (District district : country.getDistricts()) {
                        cities.addAll(district.getCities());
                    }
                }
            }
        }

        return cities;
    }

    /**
     * Get all of the cities in a given continent
     *
     * @param continentName
     * @return list of cities
     */
    public static List<City> getCitiesInContinent(String continentName) {
        List<Continent> continents = getContinents();
        List<City> cities = new ArrayList<City>();

        for (Continent continent : continents) {
            if (!continent.getName().toLowerCase().contains(continentName)) {
                continue;
            }

            for (Region region : continent.getRegions()) {
                for (Country country : region.getCountries()) {
                    for (District district : country.getDistricts()) {
                        cities.addAll(district.getCities());
                    }
                }
            }
        }

        return cities;
    }
}
