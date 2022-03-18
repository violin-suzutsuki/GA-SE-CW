package com.SET08103.cw.objects;

import java.util.ArrayList;
import java.util.List;

public class District {
    private String name;

    private List<City> cities;

    public District(String name) throws Exception {
        if (name == "") {
            throw new Exception("No name provided for district.");
        }

        this.name = name;
        this.cities = new ArrayList<City>();
    }

    /**
     * Adds a list of cities to the region.
     *
     * @param cities List of cities to add.
     */
    public void addCities(List<City> cities) {
        for (City city : cities) {
            this.cities.add(city);
        }
    }

    /**
     * Get the cities within this district.
     *
     * @return List of cities for this district.
     */
    public List<City> getCities() {
        return cities;
    }

    /**
     * Get the name of this district.
     *
     * @return Name of this district.
     */
    public String getName() {
        return name;
    }
}
