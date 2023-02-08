package com.brunolima.exercisetwo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExerciseTwoTest {
    private ExerciseTwo exerciseTwo;

    @BeforeEach
    void beforeEach() {
        List<Country> countries = new ArrayList<>();
        countries.add(new Country("US", List.of("en")));
        countries.add(new Country("BE", Arrays.asList("nl", "fr", "de")));
        countries.add(new Country("NL", Arrays.asList("nl", "fy")));
        countries.add(new Country("DE", List.of("de")));
        countries.add(new Country("ES", List.of("es")));

        exerciseTwo = new ExerciseTwo(countries);
    }

    @Test
    void countCountries() {
        assertEquals(5, exerciseTwo.countCountries());
    }

    @Test
    void findCountryWithMoreOfficialLanguages() {
        Country country = exerciseTwo.findCountryWithMoreOfficialLanguages(new Language("de"));
        assertEquals("DE", country.getAlphaTwoCode());
    }

    @Test
    void countCountryLanguagesSpoken() {
        Map<String, Integer> countries = exerciseTwo.countCountryLanguagesSpoken();

        assertEquals(1, countries.get("DE"));
        assertEquals(3, countries.get("BE"));
        assertEquals(1, countries.get("US"));
        assertEquals(2, countries.get("NL"));
        assertEquals(1, countries.get("ES"));
    }

    @Test
    void findCountryHighestNumberOfficialLanguages() {
        Country country = exerciseTwo.findCountryHighestNumberOfficialLanguages();
        assertEquals("BE", country.getAlphaTwoCode());
    }

    @Test
    void findMostCommonOfficialLanguages() {
        List<Language> mostCommonOfficialLanguages = exerciseTwo.findMostCommonOfficialLanguages();

        assertEquals("de", mostCommonOfficialLanguages.get(0).getName());
        assertEquals("nl", mostCommonOfficialLanguages.get(1).getName());
    }
}