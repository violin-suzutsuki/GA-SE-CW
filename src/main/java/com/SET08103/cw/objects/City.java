package com.SET08103.cw.objects;

import com.SET08103.cw.interfaces.Population;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * City.java
 *
 * Class to store data about a city.
 */
public class City implements Population {
    public int id;
    public String name;
    public String countryCode;
    public String district;
    public long population;

    /**
     * Constructor for the City class.
     *
     * @param id Database id of the city
     * @param name Name of the city
     * @param countryCode Country code of the city
     * @param district Which district the city is in
     * @param population Population of the city
     */
    public City(@JsonProperty("id") int id, @JsonProperty("name") String name, @JsonProperty("countryCode") String countryCode, @JsonProperty("district") String district, @JsonProperty("population") long population) throws Exception {
        if (id < 0) {
            throw new Exception("Invalid id provided for city.");
        }

        if (name == "") {
            throw new Exception("No name provided for city.");
        }

        if (countryCode == "") {
            throw new Exception("No country code provided for city.");
        }

        if (population < 0) {
            throw new Exception("Invalid population provided for city.");
        }

        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }

    /**
     * Returns the cities database id.
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the cities name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the cities country code.
     *
     * @return country code
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Returns the cities district.
     *
     * @return district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * Returns the cities population.
     *
     * @return population
     */
    public long getPopulation() {
        return population;
    }

    /**
     * Returns information about the city in a digestible string format.
     *
     * @return City information.
     */
    public String toString() {
        return String.format("City: %s (%s), country code: %s, district: %s, population: %s", name, id, countryCode, district, population);
    }
}