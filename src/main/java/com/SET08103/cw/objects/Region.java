package com.SET08103.cw.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Region.java
 *
 * Class to store data about a region.
 * 1 region -> Many countries
 */
public class Region {
    private List<Country> countries;
    private String name;

    /**
     * Constructor for Region class.
     *
     * @param name Name of the region.
     */
    public Region(String name) throws Exception {
        if (name == "") {
            throw new Exception("No name provided for region.");
        }

        this.name = name;
        this.countries = new ArrayList<Country>();
    }

    /**
     * Adds a list of countries to the region.
     *
     * @param countries List of countries to add.
     */
    public void addCountries(List<Country> countries) {
        for (Country country : countries) {
            this.countries.add(country);
        }
    }

    /**
     * Get the countries within this region.
     *
     * @return List of countries for this region.
     */
    public List<Country> getCountries() {
        return countries;
    }

    /**
     * Get the name of this region.
     *
     * @return Name of this region.
     */
    public String getName() {
        return name;
    }
}