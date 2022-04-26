package com.SET08103.cw.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * CountryLanguage.java
 *
 * contains info about country language.
 */
public class CountryLanguage {
    private String language;
    private boolean isOfficial;
    private double percentage;

    /**
     * Instantiate new instance of CountryLanguage class
     *
     * @param language
     * @param isOfficial
     * @param percentage
     */
    public CountryLanguage(@JsonProperty("language") String language, @JsonProperty("isOfficial") boolean isOfficial, @JsonProperty("percentage") double percentage) {
        this.language = language;
        this.isOfficial = isOfficial;
        this.percentage = percentage;
    }

    /**
     * Gets language string
     *
     * @return language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Gets isOfficial boolean
     *
     * @return isOfficial
     */
    public boolean getIsOfficial() {
        return isOfficial;
    }

    /**
     * Gets percentage double
     *
     * @return percentage
     */
    public double getPercentage() {
        return percentage;
    }
}