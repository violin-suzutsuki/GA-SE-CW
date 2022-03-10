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
    @RequestMapping("/api")
    public String api(@RequestParam(value="reportId") Integer id) throws JsonProcessingException {
        DataHandler dataHandler = DataHandler.getInstance();
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

        String jsonRet = "";

        switch (id)
        {
            // https://github.com/violin-suzutsuki/GA-SE-CW/issues/22
            // Create Report: All the countries in the world organised by largest population to smallest
            case 22:
                List<Country> countries = DataParser.getCountriesInContinents(dataHandler.getContinents());
                countries.sort(Comparator.comparing(Country::getPopulation).reversed());

                jsonRet = objectWriter.writeValueAsString(countries);

                break;
        }

        return jsonRet;
    }
}
