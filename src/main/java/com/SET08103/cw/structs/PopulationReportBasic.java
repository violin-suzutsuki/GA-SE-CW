package com.SET08103.cw.structs;

/**
 * PopulationReportBasic.java
 *
 * Pseudo-struct to store populationreportbasic data.
 */
public class PopulationReportBasic {
    private String name;
    private long totalPopulation;

    /**
     * Instantiate new instance of class
     *
     * @param name
     * @param totalPopulation
     */
    public PopulationReportBasic(String name, long totalPopulation) {
        this.name = name;
        this.totalPopulation = totalPopulation;
    }

    /**
     * Gets name string
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets total population long
     *
     * @return total population
     */
    public long getTotalPopulation() {
        return totalPopulation;
    }
}
