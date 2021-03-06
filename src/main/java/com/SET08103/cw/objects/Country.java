package com.SET08103.cw.objects;

import com.SET08103.cw.interfaces.Population;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.InvalidPropertyException;

import java.util.ArrayList;
import java.util.List;

/**
 * Country.java
 *
 * Class to store data about a country.
 */
public class Country implements Population {
    private String code;
    private String name;
    private String continent;
    private String region;
    private long population;
    private City capital;

    private List<District> districts;
    private List<CountryLanguage> languages;

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
    public Country(@JsonProperty("code") String code, @JsonProperty("name") String name, @JsonProperty("continent") String continent, @JsonProperty("region") String region, @JsonProperty("population") long population, @JsonProperty("capital") City capital) throws Exception {
        if (population < 0) {
            throw new Exception("Invalid population provided for country.");
        }

        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.population = population;
        this.capital = capital;
        this.districts = new ArrayList<District>();
        this.languages = new ArrayList<CountryLanguage>();
    }

    /**
     * Constructor for the Country class without the capital city.
     *
     * @param code Country code
     * @param name Name of the country
     * @param continent Continent the country is in
     * @param region Region the country is in
     * @param population Population of the country
     */
    public Country(String code, String name, String continent, String region, long population) throws Exception {
        if (population < 0) {
            throw new Exception("Invalid population provided for country.");
        }

        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.population = population;
        this.districts = new ArrayList<District>();
        this.languages = new ArrayList<CountryLanguage>();
    }

    /**
     * Adds a list of districts to the country.
     *
     * @param districts List of districts to add.
     */
    public void addDistricts(List<District> districts) {
        for (District district : districts) {
            this.districts.add(district);
        }
    }

    /**
     * Gets the list of districts in this country.
     *
     * @return List of districts.
     */
    public List<District> getDistricts() {
        return districts;
    }

    /**
     * Add a language to the country.
     *
     * @param language
     */
    public void addLanguage(CountryLanguage language) {
        languages.add(language);
    }

    /**
     * Gets the list of languages.
     *
     * @return list of languages
     */
    public List<CountryLanguage> getLanguages() {
        return languages;
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
