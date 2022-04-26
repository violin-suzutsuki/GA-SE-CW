package com.SET08103.cw.structs;

/**
 * LanguageReport.java
 *
 * Struct to support language report structure
 */
public class LanguageReport {
    private String language, percentOfWorld;
    private long population;

    /**
     * Instantiate new instance of a language report
     *
     * @param language
     * @param population
     */
    public LanguageReport(String language, long population) {
        this.language = language;
        this.population = population;
    }

    /**
     * Get language of languagereport
     *
     * @return language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Get population of languagereport
     *
     * @return population
     */
    public long getPopulation() {
        return population;
    }

    /**
     * Set percent of world string
     *
     * @param str
     */
    public void setPercentOfWorld(String str) {
        percentOfWorld = str;
    }

    /**
     * Get percent of world string
     *
     * @return percent of world
     */
    public String getPercentOfWorld() {
        return percentOfWorld;
    }
}
