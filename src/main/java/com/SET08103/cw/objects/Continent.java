package com.SET08103.cw.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Continent.java
 *
 * Class to store data about a continent.
 * 1 continent -> Many regions
 */
public class Continent {
    private List<Region> regions;
    private String name;

    /**
     * Constructor for the Continent class.
     *
     * @param name Name of the continent.
     */
    public Continent(@JsonProperty("name") String name) throws Exception {
        if (name == "") {
            throw new Exception("No name provided for continent.");
        }

        this.name = name;
        this.regions = new ArrayList<Region>();
    }

    /**
     * Adds a list of regions to the continent.
     *
     * @param regions List of regions to add.
     */
    public void addRegions(List<Region> regions) {
        for (Region region : regions) {
            this.regions.add(region);
        }
    }

    /**
     * Gets the list of regions in this continent.
     *
     * @return List of regions.
     */
    public List<Region> getRegions() {
        return regions;
    }

    /**
     * Gets the name of the continent.
     *
     * @return name of continent.
     */
    public String getName() {
        return name;
    }
}
