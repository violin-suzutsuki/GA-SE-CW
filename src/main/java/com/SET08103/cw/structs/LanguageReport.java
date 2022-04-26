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
     * intialize new instance of a language report
     *
     * @param language
     * @param population
     */
    public LanguageReport(String language, long population) {
        this.language = language;
        this.population = population;
    }

    /**
     * get language of languagereport
     *
     * @return language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * get population of languagereport
     *
     * @return population
     */
    public long getPopulation() {
        return population;
    }

    /**
     * set percent of world string
     *
     * @param str
     */
    public void setPercentOfWorld(String str) {
        percentOfWorld = str;
    }

    /**
     * get percent of world string
     *
     * @return percent of world
     */
    public String getPercentOfWorld() {
        return percentOfWorld;
    }
}
