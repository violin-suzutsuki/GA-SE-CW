package com.SET08103.cw.api;

import com.SET08103.cw.data.DataHandler;
import com.SET08103.cw.data.DataParser;
import com.SET08103.cw.objects.City;
import com.SET08103.cw.objects.Country;
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

            }

            default: {
                return "{}";
            }
        }
    }
}
