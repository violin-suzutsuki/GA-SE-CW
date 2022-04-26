package com.SET08103.cw.data;

import com.SET08103.cw.objects.*;
import com.SET08103.cw.structs.LanguageReport;
import com.SET08103.cw.structs.PopulationReport;
import com.SET08103.cw.structs.PopulationReportBasic;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * DataParser.java
 *
 * Wrapper class that communicates with the DataHandler.
 */
public final class DataParser {
    /**
     * Parses any java object into a json string.
     *
     * @param object the object to serialize
     * @return a json string, empty if there was a serialization error
     */
    public static String toJson(Object object) {
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

        String json;

        try {
            json = objectWriter.writeValueAsString(object);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return "{}";
        }

        return json;
    }

    /**
     * fromJson class using generics so that a developer can specify the type of list to return.
     * Without specifying the type, the ObjectMapper class is not able to understand how to map readValue to the List
     *
     * @param json to decode
     * @param classType class to decode to (i.e. Country.class)
     * @return list of memory instantiated objects
     */
    public static <T> List<T> fromJson(String json, Class<T> classType) {
        ObjectMapper objectMapper = new ObjectMapper();
        CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, classType);

        List<T> ret = null;

        try {
            ret = objectMapper.readValue(json, listType);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ret;
    }

    /**
     * Round to certain number of decimals
     *
     * @param d
     * @param decimalPlace
     * @return
     */
    private static float roundFloat(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }

    /**
     * DataHandler wrapper to get all of the world's continents
     *
     * @return a list of continents.
     */
    public static List<Continent> getContinents() {
        return DataHandler.getInstance().getContinents();
    }

    /**
     * Get all of the countries in the world.
     *
     * @return a list of countries
     */
    public static List<Country> getCountriesInWorld() {
        List<Continent> continents = getContinents();
        List<Country> countries = new ArrayList<Country>();

        for (Continent continent : continents) {
            for (Region region : continent.getRegions()) {
                countries.addAll(region.getCountries());
            }
        }

        return countries;
    }

    /**
     * Get all of the countries in a continent sorted by population in descending order
     *
     * @param continentName continent name to search for, non caps-sensitive
     * @return a list of countries
     */
    public static List<Country> getCountriesInContinent(String continentName) {
        List<Country> countries = new ArrayList<Country>();

        for (Country country : getCountriesInWorld()) {
            if (country.getContinent().toLowerCase().contains(continentName.toLowerCase())) {
                countries.add(country);
            }
        }

        return countries;
    }

    /**
     * Get all of the countries in a region sorted by population in descending order
     *
     * @param regionName region name to search for, non caps-sensitive
     * @return a list of countries
     */
    public static List<Country> getCountriesInRegion(String regionName) {
        List<Country> countries = new ArrayList<Country>();

        for (Country country : getCountriesInWorld()) {
            if (country.getRegion().toLowerCase().contains(regionName.toLowerCase())) {
                countries.add(country);
            }
        }

        return countries;
    }

    /**
     * Get all of the cities in the world.
     *
     * @return a list of cities
     */
    public static List<City> getCitiesInWorld() {
        List<Continent> continents = getContinents();
        List<City> cities = new ArrayList<City>();

        for (Continent continent : continents) {
            for (Region region : continent.getRegions()) {
                for (Country country : region.getCountries()) {
                    for (District district : country.getDistricts()) {
                        cities.addAll(district.getCities());
                    }
                }
            }
        }

        return cities;
    }

    /**
     * Get all of the cities in a given continent
     *
     * @param continentName
     * @return list of cities
     */
    public static List<City> getCitiesInContinent(String continentName) {
        List<Continent> continents = getContinents();
        List<City> cities = new ArrayList<City>();

        for (Continent continent : continents) {
            if (!continent.getName().toLowerCase().contains(continentName.toLowerCase())) {
                continue;
            }

            for (Region region : continent.getRegions()) {
                for (Country country : region.getCountries()) {
                    for (District district : country.getDistricts()) {
                        cities.addAll(district.getCities());
                    }
                }
            }
        }

        return cities;
    }

    /**
     * Get all of the cities in a given region
     *
     * @param regionName
     * @return list of cities
     */
    public static List<City> getCitiesInRegion(String regionName) {
        List<Continent> continents = getContinents();
        List<City> cities = new ArrayList<City>();

        for (Continent continent : continents) {
            for (Region region : continent.getRegions()) {
                if (!region.getName().toLowerCase().contains(regionName.toLowerCase())) {
                    continue;
                }

                for (Country country : region.getCountries()) {
                    for (District district : country.getDistricts()) {
                        cities.addAll(district.getCities());
                    }
                }
            }
        }

        return cities;
    }

    /**
     * Get all of the cities in a given country
     *
     * @param countryName
     * @return list of cities
     */
    public static List<City> getCitiesInCountry(String countryName) {
        List<Continent> continents = getContinents();
        List<City> cities = new ArrayList<City>();

        for (Continent continent : continents) {
            for (Region region : continent.getRegions()) {
                for (Country country : region.getCountries()) {
                    if (!country.getName().toLowerCase().contains(countryName.toLowerCase())) {
                        continue;
                    }

                    for (District district : country.getDistricts()) {
                        cities.addAll(district.getCities());
                    }
                }
            }
        }

        return cities;
    }

     /**
     * Get all of the cities in a given district
     *
     * @param districtName
     * @return list of cities
     */
    public static List<City> getCitiesInDistrict(String districtName) {
        List<Continent> continents = getContinents();
        List<City> cities = new ArrayList<City>();

        for (Continent continent : continents) {
            for (Region region : continent.getRegions()) {
                for (Country country : region.getCountries()) {
                    for (District district : country.getDistricts()) {
                        if (!district.getName().toLowerCase().contains(districtName.toLowerCase())) {
                            continue;
                        }

                        cities.addAll(district.getCities());
                    }
                }
            }
        }

        return cities;
    }

    /**
     * get all capital cities in the world
     *
     * @return list of capital cities
     */
    public static List<City> getCapitalCitiesInWorld() {
        List<Continent> continents = getContinents();
        List<City> cities = new ArrayList<City>();

        for (Continent continent : continents) {
            for (Region region : continent.getRegions()) {
                for (Country country : region.getCountries()) {
                    if (country.getCapital() == null) {
                        continue;
                    }

                    cities.add(country.getCapital());
                }
            }
        }

        return cities;
    }

    /**
     * get all capital cities in a continent
     *
     * @return list of capital cities
     */
    public static List<City> getCapitalCitiesInContinent(String continentName) {
        List<Continent> continents = getContinents();
        List<City> cities = new ArrayList<City>();

        for (Continent continent : continents) {
            if (!continent.getName().toLowerCase().contains(continentName.toLowerCase())) {
                continue;
            } 

            for (Region region : continent.getRegions()) {
                for (Country country : region.getCountries()) {
                    if (country.getCapital() == null) {
                        continue;
                    }

                    cities.add(country.getCapital());
                }
            }
        }

        return cities;
    }

    /**
     * get all capital cities in a region
     *
     * @return list of capital cities
     */
    public static List<City> getCapitalCitiesInRegion(String regionName) {
        List<Continent> continents = getContinents();
        List<City> cities = new ArrayList<City>();

        for (Continent continent : continents) {
            for (Region region : continent.getRegions()) {
                if (!region.getName().toLowerCase().contains(regionName.toLowerCase())) {
                    continue;
                } 

                for (Country country : region.getCountries()) {
                    if (country.getCapital() == null) {
                        continue;
                    }

                    cities.add(country.getCapital());
                }
            }
        }

        return cities;
    }

    /**
     * gets population of country
     *
     * @param country
     * @return population
     */
    public static long getPopulationOfCountry(Country country) {
        return country.getPopulation();
    }

    /**
     * Get population of region
     *
     * @param region
     * @return population
     */
    public static long getPopulationOfRegion(Region region) {
        long population = 0;

        for (Country country : region.getCountries()) {
            population += country.getPopulation();
        }

        return population;
    }

    /**
     * Get population of continent
     *
     * @param continent
     * @return population
     */
    public static long getPopulationOfContinent(Continent continent) {
        long population = 0;

        for (Region region : continent.getRegions()) {
            population += getPopulationOfRegion(region);
        }

        return population;
    }

    /**
     * gets city population of district
     *
     * @param district
     * @return city population
     */
    public static long getPopulationOfDistrict(District district) {
        long cityPopulation = 0;

        for (City city : district.getCities()) {
            cityPopulation += city.getPopulation();
        }

        return cityPopulation;
    }

    /**
     * gets city population of country
     *
     * @param country
     * @return city population
     */
    public static long getCityPopulationOfCountry(Country country) {
        long cityPopulation = 0;

        for (District district : country.getDistricts()) {
            for (City city : district.getCities()) {
                cityPopulation += city.getPopulation();
            }
        }

        return cityPopulation;
    }

    /**
     * Get city population of region
     *
     * @param region
     * @return city population
     */
    public static long getCityPopulationOfRegion(Region region) {
        long cityPopulation = 0;

        for (Country country : region.getCountries()) {
            cityPopulation += getPopulationOfCountry(country);
        }

        return cityPopulation;
    }

    /**
     * Get city population of continent
     *
     * @param continent
     * @return city population
     */
    public static long getCityPopulationOfContinent(Continent continent) {
        long cityPopulation = 0;

        for (Region region : continent.getRegions()) {
            cityPopulation += getCityPopulationOfRegion(region);
        }

        return cityPopulation;
    }

    /**
     * gets population data based on name, totalPopulation, cityPopulation
     *
     * @param name
     * @param totalPopulation
     * @param cityPopulation
     * @return
     */
    public static PopulationReport getPopReport(String name, long totalPopulation, long cityPopulation) {
        if (cityPopulation > totalPopulation) {
            cityPopulation = totalPopulation;
        }

        long notInCityPopulation = totalPopulation - cityPopulation;

        float cityPop = totalPopulation == 0 ? 0 : 100 * ((float) cityPopulation / (float) totalPopulation);
        cityPop = roundFloat(cityPop, 2);

        float notInCityPop = totalPopulation == 0 ? 0 : 100 * ((float) notInCityPopulation / (float) totalPopulation);
        notInCityPop = roundFloat(notInCityPop, 2);

        PopulationReport data = new PopulationReport(name, totalPopulation);
        data.setPopulationInCities(String.format("%s (%s%%)", cityPopulation, cityPop));
        data.setPopulationNotInCities(String.format("%s (%s%%)", notInCityPopulation, notInCityPop));

        return data;
    }

    /**
     * Get population data for all continents
     *
     * @return list of populationdata
     */
    public static List<PopulationReport> getPopulationDataForContinents() {
        List<Continent> continents = getContinents();
        List<PopulationReport> data = new ArrayList<PopulationReport>();

        for (Continent continent : continents) {
            long totalPopulation = getPopulationOfContinent(continent);
            long cityPopulation = getCityPopulationOfContinent(continent);

            data.add(getPopReport(continent.getName(), totalPopulation, cityPopulation));
        }

        return data;
    }

    /**
     * get population data for regions
     * @return list of data
     */
    public static List<PopulationReport> getPopulationDataForRegions() {
        List<Continent> continents = getContinents();
        List<PopulationReport> data = new ArrayList<PopulationReport>();

        for (Continent continent : continents) {
            for (Region region : continent.getRegions()) {
                long totalPopulation = getPopulationOfRegion(region);
                long cityPopulation = getCityPopulationOfRegion(region);

                data.add(getPopReport(region.getName(), totalPopulation, cityPopulation));
            }
        }

        return data;
    }

    /**
     * get population data for countries
     *
     * @return list of data
     */
    public static List<PopulationReport> getPopulationDataForCountries() {
        List<Continent> continents = getContinents();
        List<PopulationReport> data = new ArrayList<PopulationReport>();

        for (Continent continent : continents) {
            for (Region region : continent.getRegions()) {
                for (Country country : region.getCountries()) {
                    long totalPopulation = getPopulationOfCountry(country);
                    long cityPopulation = getCityPopulationOfCountry(country);

                    data.add(getPopReport(country.getName(), totalPopulation, cityPopulation));
                }
            }
        }

        return data;
    }

    /**
     * get basic pop data of world
     * @return list of data
     */
    public static List<PopulationReportBasic> getPopulationBasicOfWorld() {
        List<PopulationReportBasic> data = new ArrayList<PopulationReportBasic>();

        long population = 0;

        for (PopulationReport data2 : getPopulationDataForContinents()) {
            population += data2.getTotalPopulation();
        }

        data.add(new PopulationReportBasic("world", population));

        return data;
    }

    /**
     * get basic pop data of continent
     * @return list of data
     */
    public static List<PopulationReportBasic> getPopulationBasicOfContinent(String continentName) {
        List<Continent> continents = getContinents();
        List<PopulationReportBasic> data = new ArrayList<PopulationReportBasic>();

        for (Continent continent : continents) {
            if (!continent.getName().toLowerCase().contains(continentName.toLowerCase())) {
                continue;
            }

            data.add(new PopulationReportBasic(continent.getName(), getPopulationOfContinent(continent)));
        }

        return data;
    }

    /**
     * get basic pop data of region
     * @return list of data
     */
    public static List<PopulationReportBasic> getPopulationBasicOfRegion(String regionName) {
        List<Continent> continents = getContinents();
        List<PopulationReportBasic> data = new ArrayList<PopulationReportBasic>();

        for (Continent continent : continents) {
            for (Region region : continent.getRegions()) {
                if (!region.getName().toLowerCase().contains(regionName.toLowerCase())) {
                    continue;
                }

                data.add(new PopulationReportBasic(region.getName(), getPopulationOfRegion(region)));
            }
        }

        return data;
    }

    /**
     * get basic pop data of country
     * @return list of data
     */
    public static List<PopulationReportBasic> getPopulationBasicOfCountry(String countryName) {
        List<Continent> continents = getContinents();
        List<PopulationReportBasic> data = new ArrayList<PopulationReportBasic>();

        for (Continent continent : continents) {
            for (Region region : continent.getRegions()) {
                for (Country country : region.getCountries()) {
                    if (!country.getName().toLowerCase().contains(countryName.toLowerCase())) {
                        continue;
                    }

                    data.add(new PopulationReportBasic(country.getName(), getPopulationOfCountry(country)));
                }
            }
        }

        return data;
    }

    /**
     * get basic pop data of district
     * @return list of data
     */
    public static List<PopulationReportBasic> getPopulationBasicOfDistrict(String districtName) {
        List<Continent> continents = getContinents();
        List<PopulationReportBasic> data = new ArrayList<PopulationReportBasic>();

        for (Continent continent : continents) {
            for (Region region : continent.getRegions()) {
                for (Country country : region.getCountries()) {
                    for (District district : country.getDistricts()) {
                        if (!district.getName().toLowerCase().contains(districtName.toLowerCase())) {
                            continue;
                        }

                        data.add(new PopulationReportBasic(district.getName(), getPopulationOfDistrict(district)));
                    }
                }
            }
        }

        return data;
    }

    /**
     * get basic pop data of city
     * @return list of data
     */
    public static List<PopulationReportBasic> getPopulationBasicOfCity(String cityName) {
        List<Continent> continents = getContinents();
        List<PopulationReportBasic> data = new ArrayList<PopulationReportBasic>();

        for (Continent continent : continents) {
            for (Region region : continent.getRegions()) {
                for (Country country : region.getCountries()) {
                    for (District district : country.getDistricts()) {
                        for (City city : district.getCities()) {
                            if (!city.getName().toLowerCase().contains(cityName.toLowerCase())) {
                                continue;
                            }

                            data.add(new PopulationReportBasic(city.getName(), city.getPopulation()));
                        }
                    }
                }
            }
        }

        return data;
    }

    public static List<LanguageReport> getLanguageReports(List<String> languages) {
        List<LanguageReport> reports = new ArrayList<LanguageReport>();

        long worldPopulation = getPopulationBasicOfWorld().get(0).getTotalPopulation();

        for (String language : languages) {
            long population = 0;

            for (Continent continent : getContinents()) {
                for (Region region : continent.getRegions()) {
                    for (Country country : region.getCountries()) {
                        System.out.println("Country loop: " + country.getName());
                        System.out.println("Country has: " + country.getLanguages().stream().count() + " languages");

                        for (CountryLanguage languageRecord : country.getLanguages()) {
                            System.out.println(String.format("Comparing %s to %s, %s", languageRecord.getLanguage(), language, languageRecord.getLanguage() == language));

                            if (languageRecord.getLanguage().toLowerCase().contains(language.toLowerCase())) {
                                System.out.println("Got language: " + language);

                                double num = Math.floor((double)country.getPopulation() * languageRecord.getPercentage());
                                System.out.println("Got num: " + num + "(" + country.getPopulation() + " * " + languageRecord.getPercentage() + ")");

                                population += (long)num;
                                System.out.println("New pop: " + population);

                                break;
                            }
                        }
                    }
                }
            }

            System.out.println("done");

            float worldPopPercent = 100 * ((float) population / (float) worldPopulation);
            worldPopPercent = roundFloat(worldPopPercent, 2);

            LanguageReport report = new LanguageReport(language, population);
            report.setPercentOfWorld(String.format("%s%%", worldPopPercent));

            reports.add(report);
        }

        return reports;
    }
}