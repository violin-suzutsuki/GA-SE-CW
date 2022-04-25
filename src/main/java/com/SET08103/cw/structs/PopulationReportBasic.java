package com.SET08103.cw.structs;

/**
 * PopulationReportBasic.java
 *
 * Pseudo-struct to store populationreportbasic data.
 */
public class PopulationReportBasic {
    private String name;
    private long totalPopulation;

    public PopulationReportBasic(String name, long totalPopulation) {
        this.name = name;
        this.totalPopulation = totalPopulation;
    }

    public String getName() {
        return name;
    }

    public long getTotalPopulation() {
        return totalPopulation;
    }
}
