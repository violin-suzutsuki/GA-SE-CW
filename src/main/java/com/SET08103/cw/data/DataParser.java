package com.SET08103.cw.data;

import com.SET08103.cw.objects.Continent;
import com.SET08103.cw.objects.Country;
import com.SET08103.cw.objects.Region;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

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
    public static String toJson(Object object)
    {
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

        String json;

        try {
            json = objectWriter.writeValueAsString(object);
        }
        catch(Exception e)
        {
            return "{}";
        }

        return json;
    }

    /**
     * DataHandler wrapper to get all of the world's continents
     *
     * @return a list of continents.
     */
    public static List<Continent> getContinents()
    {
        return DataHandler.getInstance().getContinents();
    }

    /**
     * Get all of the countries in the world sorted by population in descending order
     *
     * @return a list of countries
     */
    public static List<Country> getCountriesInWorld()
    {
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
    public static List<Country> getCountriesInContinent(String continentName)
    {
        List<Country> countries = new ArrayList<Country>();

        for (Country country : getCountriesInWorld())
        {
            if (country.getContinent().toLowerCase().contains(continentName.toLowerCase()))
            {
                countries.add(country);
            }
        }

        return countries;
    }

    public static List<Country> getCountriesInRegion(String regionName)
    {
        List<Country> countries = new ArrayList<Country>();

        for (Country country : getCountriesInWorld())
        {
            if (country.getRegion().toLowerCase().contains(regionName.toLowerCase()))
            {
                countries.add(country);
            }
        }

        return countries;
    }
}
