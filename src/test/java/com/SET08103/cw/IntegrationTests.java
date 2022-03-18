package com.SET08103.cw;

import com.SET08103.cw.api.Controller;
import com.SET08103.cw.data.DataHandler;
import com.SET08103.cw.data.DataParser;
import com.SET08103.cw.objects.Country;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
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

    @BeforeAll
    static void init() {
        dataHandler = DataHandler.getInstance();
        dataHandler.connect("localhost:3306", 100);
        dataHandler.loadContinents();

        apiController = new Controller();
    }

    @Test
    void testReport22() {
        String jsonRet = apiController.api(22, "");
        List<Country> countries = DataParser.fromJson(jsonRet, Country.class);

        assertEquals(countries.stream().count(), 239);
        assertEquals(countries.get(0).toString(), "China (capital city: [City: Peking (1891), country code: CHN, district: Peking, population: 7472000])");
    }

    @Test
    void testReport23Nothing() {
        String jsonRet = apiController.api(23, "nodata");

        assertEquals(jsonRet, "[ ]");
    }

    @Test
    void testReport23Asia() {
        String jsonRet = apiController.api(23, "asia");

        // todo
    }
}