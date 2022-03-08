package com.SET08103.cw.objects;

/**
 * Country.java
 *
 * This is the intermediate class that stores city SQL data.
 */
public class City {
    public int id;
    public String name;
    public String countryCode;
    public String district;
    public long population;

    public City(int id, String name, String countryCode, String district, long population)
    {
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }

    public String toString()
    {
        return String.format("City: %s (%s), country code: %s, district: %s, population: %s", name, id, countryCode, district, population);
    }
}