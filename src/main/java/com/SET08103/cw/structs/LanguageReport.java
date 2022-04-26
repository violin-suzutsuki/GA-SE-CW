package com.SET08103.cw.structs;

/**
 * LanguageReport.java
 *
 * Struct to support language report structure
 */
public class LanguageReport {
    private String language, percentOfWorld;
    private long population;

    public LanguageReport(String language, long population) {
        this.language = language;
        this.population = population;
    }

    public String getLanguage() {
        return language;
    }

    public long getPopulation() {
        return population;
    }

    public void setPercentOfWorld(String str) {
        percentOfWorld = str;
    }

    public String getPercentOfWorld() {
        return percentOfWorld;
    }
}
