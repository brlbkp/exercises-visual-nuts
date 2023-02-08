package com.brunolima.exercisetwo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Creates statistics from the list of countries informed
 */
public class ExerciseTwo {
    private final List<Country> countries;

    public ExerciseTwo(List<Country> countries){
        this.countries = countries;
    }

    /**
    - returns the number of countries in the world
    - finds the country with the most official languages, where they officially speak German (de).
    - that counts all the official languages spoken in the listed countries.
    - to find the country with the highest number of official languages.
    - to find the most common official language(s), of all countries.
     */
    public void printResult(){
        System.out.print("- The number of countries in the world: ");
        System.out.println(countCountries());

        System.out.print("- Finds the country with the most official languages, where they officially speak German (de): ");
        System.out.println(findCountryWithMoreOfficialLanguages(new Language("de")));

        System.out.println("- Counts all the official languages spoken in the listed countries: ");
        countCountryLanguagesSpoken()
                .forEach((country, countLanguages)
                        -> System.out.println("-- " + country + ": "+ countLanguages));

        System.out.print("- Find the country with the highest number of official languages: ");
        System.out.println(findCountryHighestNumberOfficialLanguages());

        System.out.print("- Find the most common official language(s), of all countries: ");
        String result = findMostCommonOfficialLanguages().stream().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(result);
    }

    /**
     * The number of countries in the world
     *
     * @return countries list size
     */
    public int countCountries(){
        return this.countries.size();
    }

    /**
     * Finds the country with the most official languages, where they officially speak the given language
     *
     * @param language used to filter
     * @return the country found
     */
    public Country findCountryWithMoreOfficialLanguages(Language language){
        PriorityQueue<Country> countriesMostOfficialLanguages = new PriorityQueue<>(Comparator.comparingInt(Country::countLanguages));

        for (Country country: countries){
            if (country.getLanguages().contains(language)){
                countriesMostOfficialLanguages.add(country);
            }
        }

        return countriesMostOfficialLanguages.poll();
    }

    /**
     * Counts all the official languages spoken in the listed countries
     * Note: I did it like this, but it's probably not necessary to create this method
     *
     * @return a map with AlphaCode and language size
     */
    public Map<String, Integer> countCountryLanguagesSpoken(){
        Map<String, Integer> languagesSpoken = new HashMap<>(countries.size());

        for (Country country : this.countries) {
            languagesSpoken.put(country.getAlphaTwoCode(), country.countLanguages());
        }

        return languagesSpoken;
    }

    /**
     * Find the country with the highest number of official languages
     * Note: Probably the best choice would be to return a list, as there can be ties
     *
     * @return the country found
     */
    public Country findCountryHighestNumberOfficialLanguages(){
        int highestNumberLanguages = 0;
        Country result = null;

        for (Country item :countries) {
             if (item.countLanguages() > highestNumberLanguages){
                 highestNumberLanguages = item.countLanguages();
                 result = item;
             }
        }

        return result;
    }

    /**
     * Find the most common official language(s), of all countries
     *
     * @return the list of countries (may have more than one in case of a tie)
     */
    public List<Language> findMostCommonOfficialLanguages(){
         Map<Language, Integer> languagesSpoken = new HashMap<>();

         // calculates language usage
         for (Country country: countries){
             for (Language language: country.getLanguages()){
                  int counter = 1 + languagesSpoken.getOrDefault(language, 0);
                  languagesSpoken.put(language, counter);
             }
         }

         // finds the greatest value
         int maxValue = Collections.max(languagesSpoken.values());
         List<Language> result = new ArrayList<>();

         // find the most used language
         for (Language language: languagesSpoken.keySet()){
             if (languagesSpoken.get(language) == maxValue){
                 result.add(language);
             }
         }

         return result;
    }

}
