package com.SET08103.cw.objects;

/**
 * Country.java
 *
 * Class to store data about a country.
 */
public class Country {
    private String code;
    private String name;
    private String continent;
    private String region;
    private long population;
    private City capital;

    /**
     * Constructor for the Country class.
     *
     * @param code Country code
     * @param name Name of the country
     * @param continent Continent the country is in
     * @param region Region the country is in
     * @param population Population of the country
     * @param capital Its capital city
     */
    public Country(String code, String name, String continent, String region, long population, City capital) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.population = population;
        this.capital = capital;
    }

    /**
     * Get the country code.
     *
     * @return country code.
     */
    public String getCode() {
        return code;
    }

    /**
     * Get the name of the country.
     *
     * @return country name.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the continent the country is in.
     *
     * @return continent name.
     */
    public String getContinent() {
        return continent;
    }

    /**
     * Get the region the country is in.
     *
     * @return region name.
     */
    public String getRegion() {
        return region;
    }

    /**
     * Get the total population of the country.
     *
     * @return population.
     */
    public long getPopulation() {
        return population;
    }

    /**
     * Get the capital city of the country.
     *
     * @return City
     */
    public City getCapital() {
        return capital;
    }

    /**
     * toString method for class.
     *
     * @return country name and information about its capital city in a digestible format.
     */
    public String toString() {
        return String.format("%s (capital city: [%s])", name, capital == null ? "none" : capital.toString());
    }
}
