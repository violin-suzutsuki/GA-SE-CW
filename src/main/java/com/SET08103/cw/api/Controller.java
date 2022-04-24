package com.SET08103.cw.api;

import com.SET08103.cw.data.DataHandler;
import com.SET08103.cw.data.DataParser;
import com.SET08103.cw.objects.City;
import com.SET08103.cw.objects.Country;
import com.SET08103.cw.structs.PopulationReport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

/**
 * Controller.java
 *
 * This is the class that handles requests made from the frontend website.
 */
@RestController
public class Controller {
    /**
     * API endpoint to handle the generation of reports and return the data in the format of a json string
     *
     * @param id report id to run
     * @param input any user input, defaults to "" if there is none
     * @return a json string
     */
    @RequestMapping("/report")
    public String api(@RequestParam(value="reportId") Integer id, @RequestParam(value="userInput", defaultValue="") String input, @RequestParam(value="userInput2", defaultValue="") String input2) {
        DataHandler dataHandler = DataHandler.getInstance();

        switch (id) {
            // https://github.com/violin-suzutsuki/GA-SE-CW/issues/22
            // Create Report: All the countries in the world organised by largest population to smallest
            case 22: {
                List<Country> countries = DataParser.getCountriesInWorld();
                countries.sort(Comparator.comparing(Country::getPopulation).reversed());

                return DataParser.toJson(countries);
            }

            // https://github.com/violin-suzutsuki/GA-SE-CW/issues/23
            // Create Report: All the countries in a continent organised by largest population to smallest
            case 23: {
                List<Country> countries = DataParser.getCountriesInContinent(input);
                countries.sort(Comparator.comparing(Country::getPopulation).reversed());

                return DataParser.toJson(countries);
            }

            // https://github.com/violin-suzutsuki/GA-SE-CW/issues/24
            // Create Report: All the countries in a region organised by largest population to smallest
            case 24: {
                List<Country> countries = DataParser.getCountriesInRegion(input);
                countries.sort(Comparator.comparing(Country::getPopulation).reversed());

                return DataParser.toJson(countries);
            }

            // https://github.com/violin-suzutsuki/GA-SE-CW/issues/25
            // The top N populated countries in the world where N is provided by the user
            case 25: {
                List<Country> countries = DataParser.getCountriesInWorld();
                countries.sort(Comparator.comparing(Country::getPopulation).reversed());

                int topN = Integer.parseInt(input);
                return DataParser.toJson(countries.subList(0, topN));
            }

            // https://github.com/violin-suzutsuki/GA-SE-CW/issues/26
            // The top N populated countries in a continent where N is provided by the user
            case 26: {
                List<Country> countries = DataParser.getCountriesInContinent(input);
                countries.sort(Comparator.comparing(Country::getPopulation).reversed());

                int topN = Integer.parseInt(input2);
                return DataParser.toJson(countries.subList(0, topN));
            }

            // https://github.com/violin-suzutsuki/GA-SE-CW/issues/28
            // The top N populated countries in a region where N is provided by the user
            case 28: {
                List<Country> countries = DataParser.getCountriesInRegion(input);
                countries.sort(Comparator.comparing(Country::getPopulation).reversed());

                int topN = Integer.parseInt(input2);
                return DataParser.toJson(countries.subList(0, topN));
            }

            // https://github.com/violin-suzutsuki/GA-SE-CW/issues/29
            // All the cities in the world organised by largest population to smallest
            case 29: {
                List<City> cities = DataParser.getCitiesInWorld();
                cities.sort(Comparator.comparing(City::getPopulation).reversed());

                return DataParser.toJson(cities);
            }

            // https://github.com/violin-suzutsuki/GA-SE-CW/issues/30
            // All the cities in a continent organised by largest population to smallest
            case 30: {
                List<City> cities = DataParser.getCitiesInContinent(input);
                cities.sort(Comparator.comparing(City::getPopulation).reversed());

                return DataParser.toJson(cities);
            }

            // https://github.com/violin-suzutsuki/GA-SE-CW/issues/31
            // All the cities in a region organised by largest population to smallest
            case 31: {
                List<City> cities = DataParser.getCitiesInRegion(input);
                cities.sort(Comparator.comparing(City::getPopulation).reversed());

                return DataParser.toJson(cities);
            }

            // https://github.com/violin-suzutsuki/GA-SE-CW/issues/32
            //All the cities in a country organised by largest population to smallest
            case 32:{
                List<City> cities = DataParser.getCitiesInCountry(input);
                cities.sort(Comparator.comparing(City::getPopulation).reversed());

                return DataParser.toJson(cities);
            }
            
            // https://github.com/violin-suzutsuki/GA-SE-CW/issues/33
            // All the cities in a district organised by largest population to smallest
            case 33: {
                List<City> cities = DataParser.getCitiesInDistrict(input);
                cities.sort(Comparator.comparing(City::getPopulation).reversed());

                return DataParser.toJson(cities);
            }

            // https://github.com/violin-suzutsuki/GA-SE-CW/issues/34
            // The top N populated cities in the world where N is provided by the user.
            case 34: {
                List<City> cities = DataParser.getCitiesInWorld();
                cities.sort(Comparator.comparing(City::getPopulation).reversed());

                int topN = Integer.parseInt(input);
                return DataParser.toJson(cities.subList(0, topN));
            }

            // https://github.com/violin-suzutsuki/GA-SE-CW/issues/35
            // The top N populated cities in a continent where N is provided by the user
            case 35: {
                List<City> cities = DataParser.getCitiesInContinent(input);
                cities.sort(Comparator.comparing(City::getPopulation).reversed());

                int topN = Integer.parseInt(input2);
                return DataParser.toJson(cities.subList(0, topN));
            }

            // https://github.com/violin-suzutsuki/GA-SE-CW/issues/36
            // The top N populated cities in a region where N is provided by the user
            case 36: {
                List<City> cities = DataParser.getCitiesInRegion(input);
                cities.sort(Comparator.comparing(City::getPopulation).reversed());

                int topN = Integer.parseInt(input2);
                return DataParser.toJson(cities.subList(0, topN));
            }

            // https://github.com/violin-suzutsuki/GA-SE-CW/issues/37
            // The top N populated cities in a country where N is provided by the user
            case 37: {
                List<City> cities = DataParser.getCitiesInCountry(input);
                cities.sort(Comparator.comparing(City::getPopulation).reversed());

                int topN = Integer.parseInt(input2);
                return DataParser.toJson(cities.subList(0, topN));
            }

            // https://github.com/violin-suzutsuki/GA-SE-CW/issues/38
            // The top N populated cities in a district where N is provided by the user
            case 38: {
                List<City> cities = DataParser.getCitiesInDistrict(input);
                cities.sort(Comparator.comparing(City::getPopulation).reversed());

                int topN = Integer.parseInt(input2);
                return DataParser.toJson(cities.subList(0, topN));
            }

            // https://github.com/violin-suzutsuki/GA-SE-CW/issues/39
            // All the capital cities in the world organised by largest population to smallest
            case 39: {
                List<City> cities = DataParser.getCapitalCitiesInWorld();
                cities.sort(Comparator.comparing(City::getPopulation).reversed());

                return DataParser.toJson(cities);
            }

            // https://github.com/violin-suzutsuki/GA-SE-CW/issues/40
            // All the capital cities in a continent organised by largest population to smallest
            case 40: {
                List<City> cities = DataParser.getCapitalCitiesInContinent();
                cities.sort(Comparator.comparing(City::getPopulation).reversed());

                return DataParser.toJson(cities);
            }

            // https://github.com/violin-suzutsuki/GA-SE-CW/issues/41
            // All the capital cities in a region organised by largest to smallest.
            case 41: {
                List<City> cities = DataParser.getCapitalCitiesInRegion();
                cities.sort(Comparator.comparing(City::getPopulation).reversed());

                return DataParser.toJson(cities);
            }

            // https://github.com/violin-suzutsuki/GA-SE-CW/issues/45
            // The population of people, people living in cities, and people not living in cities in each continent
            case 45: {
                List<PopulationReport> populationContinentData = DataParser.getPopulationDataForContinents();

                return DataParser.toJson(populationContinentData);
            }

            default: {
                return "{}";
            }
        }
    }
}
