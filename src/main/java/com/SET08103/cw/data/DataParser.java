package com.SET08103.cw.data;

import com.SET08103.cw.objects.*;
import com.SET08103.cw.structs.PopulationReport;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
            System.out.println(e.getMessage());
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
            if (!continent.getName().toLowerCase().contains(continentName.toLowerCase())) {
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

    /**
     * Get all of the cities in a given region
     *
     * @param regionName
     * @return list of cities
     */
    public static List<City> getCitiesInRegion(String regionName) {
        List<Continent> continents = getContinents();
        List<City> cities = new ArrayList<City>();

        for (Continent continent : continents) {
            for (Region region : continent.getRegions()) {
                if (!region.getName().toLowerCase().contains(regionName.toLowerCase())) {
                    continue;
                }

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
     * Get all of the cities in a given country
     *
     * @param countryName
     * @return list of cities
     */
    public static List<City> getCitiesInCountry(String countryName) {
        List<Continent> continents = getContinents();
        List<City> cities = new ArrayList<City>();

        for (Continent continent : continents) {
            for (Region region : continent.getRegions()) {
                for (Country country : region.getCountries()) {
                    if (!country.getName().toLowerCase().contains(countryName.toLowerCase())) {
                        continue;
                    }

                    for (District district : country.getDistricts()) {
                        cities.addAll(district.getCities());
                    }
                }
            }
        }

        return cities;
    }

     /**
     * Get all of the cities in a given district
     *
     * @param districtName
     * @return list of cities
     */
    public static List<City> getCitiesInDistrict(String districtName) {
        List<Continent> continents = getContinents();
        List<City> cities = new ArrayList<City>();

        for (Continent continent : continents) {
            for (Region region : continent.getRegions()) {
                for (Country country : region.getCountries()) {
                    for (District district : country.getDistricts()) {
                        if (!district.getName().toLowerCase().contains(districtName.toLowerCase())) {
                            continue;
                        }

                        cities.addAll(district.getCities());
                    }
                }
            }
        }

        return cities;
    }

    /**
     * Get population of continent
     *
     * @param continent
     * @return population
     */
    public static long getPopulationOfContinent(Continent continent) {
        long population = 0;

        for (Region region : continent.getRegions()) {
            for (Country country : region.getCountries()) {
                population += country.getPopulation();
            }
        }

        return population;
    }

    /**
     * Get city population of continent
     *
     * @param continent
     * @return city population
     */
    public static long getCityPopulationOfContinent(Continent continent) {
        long cityPopulation = 0;

        for (Region region : continent.getRegions()) {
            for (Country country : region.getCountries()) {
                for (District district : country.getDistricts()) {
                    for (City city : district.getCities()) {
                        cityPopulation += city.getPopulation();
                    }
                }
            }
        }

        return cityPopulation;
    }

    public static List<PopulationReport> getPopulationDataForContinents() {
        List<Continent> continents = getContinents();
        List<PopulationReport> data = new ArrayList<PopulationReport>();

        for (Continent continent : continents) {
            long totalPopulation = getPopulationOfContinent(continent);
            long cityPopulation = getCityPopulationOfContinent(continent);
            long notInCityPopulation = totalPopulation - cityPopulation;

            PopulationReport continentData = new PopulationReport(continent.getName(), totalPopulation);
            continentData.setPopulationInCities(String.format("%s (%s%%)", cityPopulation, totalPopulation == 0 ? 0 : 100 * ((float)cityPopulation / (float)totalPopulation)));
            continentData.setPopulationNotInCities(String.format("%s (%s%%)", notInCityPopulation, totalPopulation == 0 ? 0 : 100 * ((float)notInCityPopulation / (float)totalPopulation)));

            data.add(continentData);
        }

        return data;
    }
}