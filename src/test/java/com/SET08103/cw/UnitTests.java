package com.SET08103.cw;

import com.SET08103.cw.objects.City;
import com.SET08103.cw.objects.Continent;
import com.SET08103.cw.objects.Region;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * UnitTests.java
 *
 * This is the class that contains all the project's unit tests.
 * https://github.com/Kevin-Sim/SET08103/tree/master/labs/lab07
 */
public class UnitTests {
    @Test
    void testCityConstructors() {
        City city = new City(1, "testCity", "TEST", "testDistrict", 10);

        assertEquals(city.getId(), 1);
        assertEquals(city.getName(), "testCity");
        assertEquals(city.getCountryCode(), "TEST");
        assertEquals(city.getDistrict(), "testDistrict");
        assertEquals(city.getPopulation(), 10);
    }

    @Test
    void testContinentConstructors() {
        Continent continent = new Continent("testContinent");

        assertEquals(continent.getName(), "testContinent");
    }

    @Test
    void testRegionConstructors() {
        Region region = new Region("testRegion");

        assertEquals(region.getName(), "testRegion");
    }

    @Test
    void testAddContinentRegions() {
        Continent continent = new Continent("testContinent");

        Region region = new Region("testRegion");
        Region region2 = new Region("testRegion2");

        continent.addRegions(new ArrayList<Region>() {
            {
                add(region);
                add(region2);
            }
        });

        assertEquals(continent.getRegions().stream().count(), 2);
        assertEquals(continent.getRegions().get(0), region);
        assertEquals(continent.getRegions().get(1), region2);
    }

    @Test
    void testCityToString() {
        City city = new City(1, "testCity", "TEST", "testDistrict", 10);

        assertEquals(city.toString(), "City: testCity (1), country code: TEST, district: testDistrict, population: 10");
    }

}
