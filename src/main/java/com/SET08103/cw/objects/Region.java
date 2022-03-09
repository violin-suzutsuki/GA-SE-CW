package com.SET08103.cw.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Region.java
 *
 * Stores data about a region.
 * 1 region -> Many countries
 */
public class Region {
    private List<Country> countries;
    private String name;

    public Region(String name)
    {
        this.name = name;
        this.countries = new ArrayList<Country>();
    }

    public void addCountries(List<Country> countries)
    {
        for (Country country : countries)
        {
            this.countries.add(country);
        }
    }

    public List<Country> getCountries()
    {
        return countries;
    }

    public String getName()
    {
        return name;
    }
}