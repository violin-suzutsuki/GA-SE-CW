package com.SET08103.cw.structs;

/**
 * PopulationReport.java
 *
 * Pseudo-struct to store populationreport data.
 */
public class PopulationReport {
    private String name, populationInCities, populationNotInCities;
    private long totalPopulation;

    public PopulationReport(String name, long totalPopulation) {
        this.name = name;
        this.totalPopulation = totalPopulation;
    }

    public void setPopulationInCities(String str) {
        populationInCities = str;
    }

    public void setPopulationNotInCities(String str) {
        populationNotInCities = str;
    }
}