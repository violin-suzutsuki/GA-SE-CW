package com.SET08103.cw;

import com.SET08103.cw.objects.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.InvalidPropertyException;

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
    void testCityConstructors() throws Exception {
        City city = new City(1, "testCity", "TEST", "testDistrict", 10);

        assertEquals(city.getId(), 1);
        assertEquals(city.getName(), "testCity");
        assertEquals(city.getCountryCode(), "TEST");
        assertEquals(city.getDistrict(), "testDistrict");
        assertEquals(city.getPopulation(), 10);
    }

    @Test
    void testCityConstructorsInvalid() {
        assertThrows(Exception.class, () -> {
            City cityWithInvalidID = new City(-1, "testCity", "TEST", "testDistrict", 10);
        });

        assertThrows(Exception.class, () -> {
            City cityWithNoName = new City(-1, "", "TEST", "testDistrict", 10);
        });

        assertThrows(Exception.class, () -> {
            City cityWithNoCountryCode = new City(1, "TEST", "", "testDistrict", 10);
        });

        assertThrows(Exception.class, () -> {
            City cityWithInvalidPopulation = new City(1, "testCity", "TEST", "testDistrict", -10);
        });
    }

    @Test
    void testContinentConstructors() throws Exception {
        Continent continent = new Continent("testContinent");

        assertEquals(continent.getName(), "testContinent");
    }

    @Test
    void testContinentConstructorsInvalid() {
        assertThrows(Exception.class, () -> {
            Continent continentWithNoName = new Continent("");
        });
    }

    @Test
    void testRegionConstructors() throws Exception {
        Region region = new Region("testRegion");

        assertEquals(region.getName(), "testRegion");
        assertNotNull(region.getCountries());
        assertEquals(region.getCountries().stream().count(), 0);
    }

    @Test
    void testRegionConstructorsInvalid() {
        assertThrows(Exception.class, () -> {
            Region region = new Region("");
        });
    }

    @Test
    void testCountryConstructors() throws Exception {
        City city = new City(1, "testCity", "TEST", "testDistrict", 10);
        Country country = new Country("TEST", "testCountry", "continent", "region", 1, city);

        assertEquals(country.getCode(), "TEST");
        assertEquals(country.getName(), "testCountry");
        assertEquals(country.getContinent(), "continent");
        assertEquals(country.getRegion(), "region");
        assertEquals(country.getPopulation(), 1);
        assertEquals(country.getCapital(), city);
    }

    @Test
    void testCountryConstructorsInvalid() {
        assertThrows(Exception.class, () -> {
            City city = new City(1, "testCity", "TEST", "testDistrict", 10);
            Country countryWithInvalidPopulation = new Country("TEST", "testCountry", "continent", "region", -1, null);
        });
    }

    @Test
    void testDistrictConstructors() throws Exception {
        District district = new District("district");

        assertEquals(district.getName(), "district");
        assertNotNull(district.getCities());
        assertEquals(district.getCities().stream().count(), 0);
    }

    @Test
    void testAddContinentRegions() throws Exception {
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
    void testCityToString() throws Exception {
        City city = new City(1, "testCity", "TEST", "testDistrict", 10);

        assertEquals(city.toString(), "City: testCity (1), country code: TEST, district: testDistrict, population: 10");
    }

}
