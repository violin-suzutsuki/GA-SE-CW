package com.SET08103.cw;

import com.SET08103.cw.api.Controller;
import com.SET08103.cw.data.DataHandler;
import com.SET08103.cw.data.DataParser;
import com.SET08103.cw.objects.City;
import com.SET08103.cw.objects.Country;
import com.SET08103.cw.structs.LanguageReport;
import com.SET08103.cw.structs.PopulationReport;
import com.SET08103.cw.structs.PopulationReportBasic;
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
    void testReport1() {
        String jsonRet = apiController.api(1, "", "");
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
    void testReport2Invalid() {
        String jsonRet = apiController.api(2, "nodata", "");

        assertEquals(jsonRet, "[ ]");
    }

    /**
     * https://github.com/violin-suzutsuki/GA-SE-CW/issues/23
     * Test Report: All the countries in a continent organised by largest population to smallest
     * Conditions: User provided 'asia' as continent search-term
     */
    @Test
    void testReport2Asia() {
        String jsonRet = apiController.api(2, "asia", "");
        List<Country> countries = DataParser.fromJson(jsonRet, Country.class);

        assertEquals(countries.stream().count(), 51);
        assertEquals(countries.get(0).getCode(), "CHN");
    }

    /**
     * https://github.com/violin-suzutsuki/GA-SE-CW/issues/23
     * Test Report: All the countries in a continent organised by largest population to smallest
     * Conditions: User provided 'america' as continent search-term
     */
    @Test
    void testReport2America() {
        String jsonRet = apiController.api(2, "america", "");
        List<Country> countries = DataParser.fromJson(jsonRet, Country.class);

        assertEquals(countries.stream().count(), 51);assertEquals(countries.get(0).toString(), "United States (capital city: [City: Washington (3813), country code: USA, district: District of Columbia, population: 572059])");
        assertEquals(countries.get(0).getCode(), "USA");
    }

    /**
     * https://github.com/violin-suzutsuki/GA-SE-CW/issues/24
     * Create Report: All the countries in a region organised by largest population to smallest
     * Conditions: Invalid data provided by the user
     */
    @Test
    void testReport3Nothing() {
        String jsonRet = apiController.api(3, "nodata", "");

        assertEquals(jsonRet, "[ ]");
    }

    /**
     * https://github.com/violin-suzutsuki/GA-SE-CW/issues/24
     * Create Report: All the countries in a region organised by largest population to smallest
     * Conditions: User provided 'australia' as region search-term
     */
    @Test
    void testReport3Australia() {
        String jsonRet = apiController.api(3, "australia", "");
        List<Country> countries = DataParser.fromJson(jsonRet, Country.class);

        assertEquals(countries.stream().count(), 5);
        assertEquals(countries.get(0).getCode(), "AUS");
    }

    /**
     * https://github.com/violin-suzutsuki/GA-SE-CW/issues/25
     * Create Report: The top N populated countries in the world where N is provided by the user
     * Conditions: User provided 1 as limit
     */
    @Test
    void testReport4() {
        String jsonRet = apiController.api(4, "1", "");
        List<Country> countries = DataParser.fromJson(jsonRet, Country.class);

        assertEquals(countries.stream().count(), 1);
        assertEquals(countries.get(0).getCode(), "CHN");
    }

    /**
     * https://github.com/violin-suzutsuki/GA-SE-CW/issues/26
     * Create Report: The top N populated countries in a continent where N is provided by the user
     * Conditions: Asia as the continent, User provided 1 as limit
     */
    @Test
    void testReport5() {
        String jsonRet = apiController.api(5, "Asia", "1");
        List<Country> countries = DataParser.fromJson(jsonRet, Country.class);

        assertEquals(countries.stream().count(), 1);
        assertEquals(countries.get(0).getCode(), "CHN");
    }

    /**
     * https://github.com/violin-suzutsuki/GA-SE-CW/issues/28
     * Create Report: The top N populated countries in a region where N is provided by the user
     * Conditions: Eastern Asia as the region, User provided 2 as limit
     */
    @Test
    void testReport6() {
        String jsonRet = apiController.api(6, "Eastern Asia", "2");
        List<Country> countries = DataParser.fromJson(jsonRet, Country.class);

        assertEquals(countries.stream().count(), 2);
        assertEquals(countries.get(0).getCode(), "CHN");
        assertEquals(countries.get(1).getCode(), "JPN");
    }

    /**
     * https://github.com/violin-suzutsuki/GA-SE-CW/issues/29
     * Create Report: All the cities in the world organised by largest population to smallest
     * Conditions: none
     */
    @Test
    void testReport7() {
        String jsonRet = apiController.api(7, "", "");
        List<City> cities = DataParser.fromJson(jsonRet, City.class);

        assertEquals(cities.stream().count(), 4526);
        assertEquals(cities.get(0).getName(), "Mumbai (Bombay)");
        assertEquals(cities.get(1).getName(), "Seoul");
    }

    /**
     * https://github.com/violin-suzutsuki/GA-SE-CW/issues/30
     * Create Report: All the cities in a continent organised by largest population to smallest
     * Conditions: Asia as the continent
     */
    @Test
    void testReport8() {
        String jsonRet = apiController.api(8, "Asia", "");
        List<City> cities = DataParser.fromJson(jsonRet, City.class);

        assertEquals(cities.stream().count(), 1865);
        assertEquals(cities.get(0).getName(), "Mumbai (Bombay)");
        assertEquals(cities.get(1).getName(), "Seoul");
    }

    /**
     * https://github.com/violin-suzutsuki/GA-SE-CW/issues/31
     * Create Report: All the cities in a region organised by largest population to smallest
     * Conditions: Eastern Asia as the region
     */
    @Test
    void testReport9() {
        String jsonRet = apiController.api(9, "Eastern Asia", "");
        List<City> cities = DataParser.fromJson(jsonRet, City.class);

        assertEquals(cities.stream().count(), 741);
        assertEquals(cities.get(0).getName(), "Seoul");
        assertEquals(cities.get(1).getName(), "Shanghai");
    }

    /**
     * https://github.com/violin-suzutsuki/GA-SE-CW/issues/32
     * Create Report: All the cities in a country organised by largest population to smallest
     * Conditions: China as the country
     */
    @Test
    void testReport10() {
        String jsonRet = apiController.api(10, "China", "");
        List<City> cities = DataParser.fromJson(jsonRet, City.class);

        assertEquals(cities.stream().count(), 363);
        assertEquals(cities.get(0).getName(), "Shanghai");
        assertEquals(cities.get(1).getName(), "Peking");
    }

    /**
     * https://github.com/violin-suzutsuki/GA-SE-CW/issues/33
     * Create Report: All the cities in a district organised by largest population to smallest
     * Conditions: Shanghai as the district
     */
    @Test
    void testReport11() {
        String jsonRet = apiController.api(11, "Shanghai", "");
        List<City> cities = DataParser.fromJson(jsonRet, City.class);

        assertEquals(cities.stream().count(), 1);
        assertEquals(cities.get(0).getName(), "Shanghai");
    }

    /**
     * https://github.com/violin-suzutsuki/GA-SE-CW/issues/34
     * Create Report: The top N populated cities in the world where N is provided by the user
     * Conditions: 5 as N
     */
    @Test
    void testReport12() {
        String jsonRet = apiController.api(12, "5", "");
        List<City> cities = DataParser.fromJson(jsonRet, City.class);

        assertEquals(cities.stream().count(), 5);
        assertEquals(cities.get(0).getName(), "Mumbai (Bombay)");
        assertEquals(cities.get(1).getName(), "Seoul");
        assertEquals(cities.get(3).getName(), "Shanghai");
        assertEquals(cities.get(4).getName(), "Jakarta");
    }

    /**
     * https://github.com/violin-suzutsuki/GA-SE-CW/issues/35
     * Create Report: The top N populated cities in a continent where N is provided by the user
     * Conditions: Asia as the continent, 5 as N
     */
    @Test
    void testReport13() {
        String jsonRet = apiController.api(13, "Asia", "5");
        List<City> cities = DataParser.fromJson(jsonRet, City.class);

        assertEquals(cities.stream().count(), 5);
        assertEquals(cities.get(0).getName(), "Mumbai (Bombay)");
        assertEquals(cities.get(1).getName(), "Seoul");
        assertEquals(cities.get(2).getName(), "Shanghai");
        assertEquals(cities.get(3).getName(), "Jakarta");
        assertEquals(cities.get(4).getName(), "Karachi");
    }

    /**
     * https://github.com/violin-suzutsuki/GA-SE-CW/issues/36
     * Create Report: The top N populated cities in a region where N is provided by the user
     * Conditions: Eastern Asia as the region, 5 as N
     */
    @Test
    void testReport14() {
        String jsonRet = apiController.api(14, "Eastern Asia", "5");
        List<City> cities = DataParser.fromJson(jsonRet, City.class);

        assertEquals(cities.stream().count(), 5);
        assertEquals(cities.get(0).getName(), "Seoul");
        assertEquals(cities.get(1).getName(), "Shanghai");
        assertEquals(cities.get(2).getName(), "Tokyo");
        assertEquals(cities.get(3).getName(), "Peking");
        assertEquals(cities.get(4).getName(), "Chongqing");
    }

    /**
     * https://github.com/violin-suzutsuki/GA-SE-CW/issues/37
     * Create Report: The top N populated cities in a country where N is provided by the user
     * Conditions: China as the country, 5 as N
     */
    @Test
    void testReport15() {
        String jsonRet = apiController.api(15, "China", "5");
        List<City> cities = DataParser.fromJson(jsonRet, City.class);

        assertEquals(cities.stream().count(), 5);
        assertEquals(cities.get(0).getName(), "Shanghai");
        assertEquals(cities.get(1).getName(), "Peking");
        assertEquals(cities.get(2).getName(), "Chongqing");
        assertEquals(cities.get(3).getName(), "Tianjin");
        assertEquals(cities.get(4).getName(), "Wuhan");
    }

    /**
     * https://github.com/violin-suzutsuki/GA-SE-CW/issues/38
     * Create Report: The top N populated cities in a district where N is provided by the user
     * Conditions: Shanghai as the district, 5 as N
     */
    @Test
    void testReport16() {
        String jsonRet = apiController.api(16, "Shanghai", "5");
        List<City> cities = DataParser.fromJson(jsonRet, City.class);

        assertEquals(cities.stream().count(), 1);
        assertEquals(cities.get(0).getName(), "Shanghai");
    }

    /**
     * https://github.com/violin-suzutsuki/GA-SE-CW/issues/39
     * Create Report: All the capital cities in the world organised by largest population to smallest
     * Conditions: none
     */
    @Test
    void testReport17() {
        String jsonRet = apiController.api(17, "", "");
        List<City> cities = DataParser.fromJson(jsonRet, City.class);

        assertEquals(cities.stream().count(), 232);
        assertEquals(cities.get(0).getName(), "Seoul");
    }

    /**
     * https://github.com/violin-suzutsuki/GA-SE-CW/issues/40
     * Create Report: All the capital cities in a continent organised by largest population to smallest
     * Conditions: Asia as the continent
     */
    @Test
    void testReport18() {
        String jsonRet = apiController.api(18, "Asia", "");
        List<City> cities = DataParser.fromJson(jsonRet, City.class);

        assertEquals(cities.stream().count(), 51);
        assertEquals(cities.get(0).getName(), "Seoul");
        assertEquals(cities.get(1).getName(), "Jakarta");
        assertEquals(cities.get(2).getName(), "Tokyo");
    }

    /**
     * https://github.com/violin-suzutsuki/GA-SE-CW/issues/41
     * Create Report: All the capital cities in a region organised by largest to smallest
     * Conditions: Eastern Asia as the region
     */
    @Test
    void testReport19() {
        String jsonRet = apiController.api(19, "Eastern Asia", "");
        List<City> cities = DataParser.fromJson(jsonRet, City.class);

        assertEquals(cities.stream().count(), 8);
        assertEquals(cities.get(0).getName(), "Seoul");
        assertEquals(cities.get(1).getName(), "Tokyo");
        assertEquals(cities.get(2).getName(), "Peking");
        assertEquals(cities.get(3).getName(), "Taipei");
    }

    /**
     * https://github.com/violin-suzutsuki/GA-SE-CW/issues/42
     * Create Report: The top N populated capital cities in the world where N is provided by the user
     * Conditions: 5 as N
     */
    @Test
    void testReport20() {
        String jsonRet = apiController.api(20, "5", "");
        List<City> cities = DataParser.fromJson(jsonRet, City.class);

        assertEquals(cities.stream().count(), 5);
        assertEquals(cities.get(0).getName(), "Seoul");
        assertEquals(cities.get(1).getName(), "Jakarta");
    }

    /**
     * https://github.com/violin-suzutsuki/GA-SE-CW/issues/43
     * Create Report: The top N populated capital cities in a continent where N is provided by the user
     * Conditions: Asia as the continent, 5 as N
     */
    @Test
    void testReport21() {
        String jsonRet = apiController.api(21, "Asia", "5");
        List<City> cities = DataParser.fromJson(jsonRet, City.class);

        assertEquals(cities.stream().count(), 5);
        assertEquals(cities.get(0).getName(), "Seoul");
        assertEquals(cities.get(1).getName(), "Jakarta");
    }

    /**
     * https://github.com/violin-suzutsuki/GA-SE-CW/issues/44
     * Create Report: The top N populated capital cities in a region where N is provided by the user
     * Conditions: Eastern Asia as the region, 5 as N
     */
    @Test
    void testReport22() {
        String jsonRet = apiController.api(22, "Eastern Asia", "5");
        List<City> cities = DataParser.fromJson(jsonRet, City.class);

        assertEquals(cities.stream().count(), 5);
        assertEquals(cities.get(0).getName(), "Seoul");
        assertEquals(cities.get(1).getName(), "Tokyo");
        assertEquals(cities.get(2).getName(), "Peking");
        assertEquals(cities.get(3).getName(), "Taipei");
        assertEquals(cities.get(4).getName(), "Pyongyang");
    }

    /**
     * https://github.com/violin-suzutsuki/GA-SE-CW/issues/45
     * Create Report: The population of people, people living in cities, and people not living in cities in each continent
     * Conditions: none
     */
    @Test
    void testReport23() {
        String jsonRet = apiController.api(23, "", "");
        List<PopulationReport> reports = DataParser.fromJson(jsonRet, PopulationReport.class);

        assertEquals(reports.stream().count(), 7);
        assertEquals(reports.get(0).getName(), "North America");
        assertEquals(reports.get(0).getTotalPopulation(), 482993000);
        assertEquals(reports.get(0).getPopulationInCities(), "482993000 (100.0%)");
    }

    /**
     * https://github.com/violin-suzutsuki/GA-SE-CW/issues/46
     * Create Report: The population of people, people living in cities, and people not living in cities in each region
     * Conditions: none
     */
    @Test
    void testReport24() {
        String jsonRet = apiController.api(24, "", "");
        List<PopulationReport> reports = DataParser.fromJson(jsonRet, PopulationReport.class);

        assertEquals(reports.stream().count(), 25);
        assertEquals(reports.get(0).getName(), "Caribbean");
        assertEquals(reports.get(0).getTotalPopulation(), 38140000);
        assertEquals(reports.get(0).getPopulationInCities(), "38140000 (100.0%)");
    }

    /**
     * https://github.com/violin-suzutsuki/GA-SE-CW/issues/47
     * Create Report: The population of people, people living in cities, and people not living in cities in each country
     * Conditions: none
     */
    @Test
    void testReport25() {
        String jsonRet = apiController.api(25, "", "");
        List<PopulationReport> reports = DataParser.fromJson(jsonRet, PopulationReport.class);

        assertEquals(reports.stream().count(), 239);
        assertEquals(reports.get(0).getName(), "Aruba");
        assertEquals(reports.get(0).getTotalPopulation(), 103000);
        assertEquals(reports.get(0).getPopulationInCities(), "103000 (100.0%)");
    }

    /**
     * https://github.com/violin-suzutsuki/GA-SE-CW/issues/48
     * Create Report: Population of the following: (world,continent,region,country,district,city)
     * Conditions: varied
     */
    @Test
    void testReport26() {
        String jsonRet = apiController.api(26, "", "");
        List<PopulationReportBasic> reports = DataParser.fromJson(jsonRet, PopulationReportBasic.class);

        assertEquals(reports.stream().count(), 1);
        assertEquals(reports.get(0).getName(), "world");
        assertEquals(reports.get(0).getTotalPopulation() + "", "6078749450");
    }

    // Continent: Asia
    @Test
    void testReport27() {
        String jsonRet = apiController.api(27, "Asia", "");
        List<PopulationReportBasic> reports = DataParser.fromJson(jsonRet, PopulationReportBasic.class);

        assertEquals(reports.stream().count(), 1);
        assertEquals(reports.get(0).getName(), "Asia");
        assertEquals(reports.get(0).getTotalPopulation() + "", "3705025700");
    }

    // Region: Eastern Asia
    @Test
    void testReport28() {
        String jsonRet = apiController.api(28, "Eastern Asia", "");
        List<PopulationReportBasic> reports = DataParser.fromJson(jsonRet, PopulationReportBasic.class);

        assertEquals(reports.stream().count(), 1);
        assertEquals(reports.get(0).getName(), "Eastern Asia");
        assertEquals(reports.get(0).getTotalPopulation() + "", "1507328000");
    }

    // Country: China
    @Test
    void testReport29() {
        String jsonRet = apiController.api(29, "China", "");
        List<PopulationReportBasic> reports = DataParser.fromJson(jsonRet, PopulationReportBasic.class);

        assertEquals(reports.stream().count(), 1);
        assertEquals(reports.get(0).getName(), "China");
        assertEquals(reports.get(0).getTotalPopulation() + "", "1277558000");
    }

    // District: Shanghai
    @Test
    void testReport30() {
        String jsonRet = apiController.api(30, "Shanghai", "");
        List<PopulationReportBasic> reports = DataParser.fromJson(jsonRet, PopulationReportBasic.class);

        assertEquals(reports.stream().count(), 1);
        assertEquals(reports.get(0).getName(), "Shanghai");
        assertEquals(reports.get(0).getTotalPopulation() + "", "9696300");
    }

    // City: Edinburgh
    @Test
    void testReport31() {
        String jsonRet = apiController.api(31, "Edinburgh", "");
        List<PopulationReportBasic> reports = DataParser.fromJson(jsonRet, PopulationReportBasic.class);

        assertEquals(reports.stream().count(), 1);
        assertEquals(reports.get(0).getName(), "Edinburgh");
        assertEquals(reports.get(0).getTotalPopulation() + "", "450180");
    }

    /**
     * https://github.com/violin-suzutsuki/GA-SE-CW/issues/49
     * Create Report: Provide the number of people who speak the following languages (from greatest to smallest) - Chinese,English,Hindi,Spanish, Arabic
     * Conditions: none
     */
    @Test
    void testReport32() {
        String jsonRet = apiController.api(32, "", "");
        List<LanguageReport> reports = DataParser.fromJson(jsonRet, LanguageReport.class);

        assertEquals(reports.stream().count(), 5);
        assertEquals(reports.get(0).getLanguage(), "Chinese");
        assertEquals(reports.get(0).getPercentOfWorld(), "19.61%");
    }
}