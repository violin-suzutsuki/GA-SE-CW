package com.SET08103.cw.objects;

/**
 * City.java
 *
 * Class to store data about a city.
 */
public class City {
    public int id;
    public String name;
    public String countryCode;
    public String district;
    public long population;

    /**
     * Constructor for the City class.
     *
     * @param id Database id of the city
     * @param name Name of the city
     * @param countryCode Country code of the city
     * @param district Which district the city is in
     * @param population Population of the city
     */
    public City(int id, String name, String countryCode, String district, long population) {
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }

    /**
     * Returns information about the city in a digestible string format.
     *
     * @return City information.
     */
    public String toString() {
        return String.format("City: %s (%s), country code: %s, district: %s, population: %s", name, id, countryCode, district, population);
    }
}