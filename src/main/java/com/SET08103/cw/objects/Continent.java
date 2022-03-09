package com.SET08103.cw.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Continent.java
 *
 * Stores data about a continent.
 * 1 continent -> Many regions
 */
public class Continent {
    private List<Region> regions;
    private String name;

    public Continent(String name)
    {
        this.name = name;
        this.regions = new ArrayList<Region>();
    }

    public void addRegions(List<Region> regions)
    {
        for (Region region : regions)
        {
            this.regions.add(region);
        }
    }

    public List<Region> getRegions()
    {
        return regions;
    }

    public String getName()
    {
        return name;
    }
}
