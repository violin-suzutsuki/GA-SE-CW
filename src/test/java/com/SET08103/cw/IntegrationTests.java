package com.SET08103.cw;

import com.SET08103.cw.api.Controller;
import com.SET08103.cw.data.DataHandler;
import com.SET08103.cw.data.DataParser;
import com.SET08103.cw.objects.Country;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * IntegrationTests.java
 *
 * This is the class that contains all the project's integration tests.
 * https://github.com/Kevin-Sim/SET08103/tree/master/labs/lab08
 */
public class IntegrationTests
{
    static DataHandler dataHandler;
    static Controller apiController;

    /**
     * Connect to a local docker container with exposed ports,
     * and instantiate a new instance of the api controller.
     *
     * This code runs once before any tests are run.
     */
    @BeforeAll
    static void init() {
        dataHandler = DataHandler.getInstance();
        dataHandler.connect("localhost:3306", 100);
        dataHandler.loadContinents();

        apiController = new Controller();
    }

    /**
     * https://github.com/violin-suzutsuki/GA-SE-CW/issues/22
     * Test Report: All the countries in the world organised by largest population to smallest
     * Conditions: Standard
     */
    @Test
    void testReport22() {
        String jsonRet = apiController.api(22, "");
        List<Country> countries = DataParser.fromJson(jsonRet, Country.class);

        assertEquals(countries.stream().count(), 239);
        assertEquals(countries.get(0).toString(), "China (capital city: [City: Peking (1891), country code: CHN, district: Peking, population: 7472000])");
    }

    /**
     * https://github.com/violin-suzutsuki/GA-SE-CW/issues/23
     * Test Report: All the countries in a continent organised by largest population to smallest
     * Conditions: Invalid data provided by the user
     */
    @Test
    void testReport23Invalid() {
        String jsonRet = apiController.api(23, "nodata");

        assertEquals(jsonRet, "[ ]");
    }

    /**
     * https://github.com/violin-suzutsuki/GA-SE-CW/issues/23
     * Test Report: All the countries in a continent organised by largest population to smallest
     * Conditions: User provided 'asia' as continent search-term
     */
    @Test
    void testReport23Asia() {
        String jsonRet = apiController.api(23, "asia");
        List<Country> countries = DataParser.fromJson(jsonRet, Country.class);

        assertEquals(countries.stream().count(), 51);
        assertEquals(countries.get(0).toString(), "China (capital city: [City: Peking (1891), country code: CHN, district: Peking, population: 7472000])");
    }

    /**
     * https://github.com/violin-suzutsuki/GA-SE-CW/issues/23
     * Test Report: All the countries in a continent organised by largest population to smallest
     * Conditions: User provided 'america' as continent search-term
     */
    @Test
    void testReport23America() {
        String jsonRet = apiController.api(23, "america");
        List<Country> countries = DataParser.fromJson(jsonRet, Country.class);

        assertEquals(countries.stream().count(), 51);
        assertEquals(countries.get(0).toString(), "United States (capital city: [City: Washington (3813), country code: USA, district: District of Columbia, population: 572059])");
    }

    /**
     * https://github.com/violin-suzutsuki/GA-SE-CW/issues/24
     * Create Report: All the countries in a region organised by largest population to smallest
     * Conditions: Invalid data provided by the user
     */
    @Test
    void testReport24Nothing() {
        String jsonRet = apiController.api(24, "nodata");

        assertEquals(jsonRet, "[ ]");
    }

    /**
     * https://github.com/violin-suzutsuki/GA-SE-CW/issues/24
     * Create Report: All the countries in a region organised by largest population to smallest
     * Conditions: User provided 'australia' as region search-term
     */
    @Test
    void testReport24Australia() {
        String jsonRet = apiController.api(24, "australia");
        List<Country> countries = DataParser.fromJson(jsonRet, Country.class);

        assertEquals(countries.stream().count(), 5);
        assertEquals(countries.get(0).toString(), "Australia (capital city: [City: Canberra (135), country code: AUS, district: Capital Region, population: 322723])");
    }
}