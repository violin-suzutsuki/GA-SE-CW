package com.SET08103.cw.structs;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * PopulationReport.java
 *
 * Pseudo-struct to store populationreport data.
 */
public class PopulationReport {
    private String name, populationInCities, populationNotInCities;
    private long totalPopulation;

    /**
     * Instantiate new instance of class
     *
     * @param name
     * @param totalPopulation
     */
    public PopulationReport(@JsonProperty("name") String name, @JsonProperty("totalPopulation") long totalPopulation) {
        this.name = name;
        this.totalPopulation = totalPopulation;
    }

    /**
     * Sets population in cities
     *
     * @param str
     */
    public void setPopulationInCities(String str) {
        populationInCities = str;
    }

    /**
     * Sets population not in cities
     *
     * @param str
     */
    public void setPopulationNotInCities(String str) {
        populationNotInCities = str;
    }

    /**
     * Gets name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets total population
     *
     * @return total population
     */
    public long getTotalPopulation() {
        return totalPopulation;
    }

    /**
     * Gets population in cities
     *
     * @return population in cities
     */
    public String getPopulationInCities() {
        return populationInCities;
    }

    /**
     * Gets population not in cities
     *
     * @return population not in cities
     */
    public String getPopulationNotInCities() {
        return populationNotInCities;
    }
}