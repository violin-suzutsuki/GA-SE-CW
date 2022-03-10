package com.SET08103.cw.api;

import com.SET08103.cw.data.DataHandler;
import com.SET08103.cw.data.DataParser;
import com.SET08103.cw.objects.Country;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.util.ArrayList;
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
    @RequestMapping("/api")
    public String api(@RequestParam(value="reportId") Integer id, @RequestParam(value="userInput", defaultValue="") String input) {
        DataHandler dataHandler = DataHandler.getInstance();

        switch (id)
        {
            // https://github.com/violin-suzutsuki/GA-SE-CW/issues/22
            // Create Report: All the countries in the world organised by largest population to smallest
            case 22:
            {
                List<Country> countries = DataParser.getCountriesInWorld();
                countries.sort(Comparator.comparing(Country::getPopulation).reversed());

                return DataParser.toJson(countries);
            }

            // https://github.com/violin-suzutsuki/GA-SE-CW/issues/23
            // Create Report: All the countries in a continent organised by largest population to smallest
            case 23:
            {
                List<Country> countries = DataParser.getCountriesInContinent(input);
                countries.sort(Comparator.comparing(Country::getPopulation).reversed());

                return DataParser.toJson(countries);
            }

            // https://github.com/violin-suzutsuki/GA-SE-CW/issues/24
            // Create Report: All the countries in a region organised by largest population to smallest
            case 24:
            {
                List<Country> countries = DataParser.getCountriesInRegion(input);
                countries.sort(Comparator.comparing(Country::getPopulation).reversed());

                return DataParser.toJson(countries);
            }

            default:
            {
                return "";
            }
        }
    }
}
