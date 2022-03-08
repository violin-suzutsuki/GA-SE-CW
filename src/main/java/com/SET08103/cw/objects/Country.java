package com.SET08103.cw.objects;

/**
 * Country.java
 *
 * This is the intermediate class that stores country SQL data.
 */
public class Country
{
    private String code;
    private String name;
    private String continent;
    private String region;
    private long population;
    private City capital;

    public Country(String code, String name, String continent, String region, long population, City capital)
    {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.population = population;
        this.capital = capital;
    }

    public String getCode()
    {
        return code;
    }

    public String getName()
    {
        return name;
    }

    public String getContinent()
    {
        return continent;
    }

    public String getRegion()
    {
        return region;
    }

    public long getPopulation()
    {
        return population;
    }

    public City getCapital()
    {
        return capital;
    }

    public String toString()
    {
        return String.format("Country: %s, code: %s, continent: %s, region: %s, capital city: [%s]", name, code, continent, region, capital == null ? "none" : capital.toString());
    }
}
