package com.SET08103.cw.data;

import com.SET08103.cw.objects.Continent;
import com.SET08103.cw.objects.Country;
import com.SET08103.cw.objects.Region;

import java.util.ArrayList;
import java.util.List;

/**
 * DataHandler.java
 *
 * This is the class that handles parsing the in-memory sql objects. It is responsible for generating the data used for reports.
 */
public final class DataParser {
    public static List<Country> getCountriesInContinents(List<Continent> continents)
    {
        List<Country> countries = new ArrayList<Country>();

        for (Continent continent : continents) {
            for (Region region : continent.getRegions()) {
                countries.addAll(region.getCountries());
            }
        }

        return countries;
    }
}
