package com.SET08103.cw.objects;

/**
 * CountryLanguage.java
 *
 * contains info about country language.
 */
public class CountryLanguage {
    private String language;
    private boolean isOfficial;
    private double percentage;

    public CountryLanguage(String language, boolean isOfficial, double percentage) {
        this.language = language;
        this.isOfficial = isOfficial;
        this.percentage = percentage;
    }

    public String getLanguage() {
        return language;
    }

    public boolean getIsOfficial() {
        return isOfficial;
    }

    public double getPercentage() {
        return percentage;
    }
}