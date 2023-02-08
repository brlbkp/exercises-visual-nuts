package com.brunolima;

import com.brunolima.exerciseone.ExerciseOne;
import com.brunolima.exercisetwo.Country;
import com.brunolima.exercisetwo.ExerciseTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n# Exercise One");
        ExerciseOne exerciseOne = new ExerciseOne("Visual", "Nuts");
        List<String> items = exerciseOne.generateList(15);
        items.forEach(System.out::println);

        System.out.println("\n# Exercise Two");
        ExerciseTwo exerciseTwo = new ExerciseTwo(getCountryList());
        exerciseTwo.printResult();
    }

    private static List<Country> getCountryList() {
        List<Country> countries = new ArrayList<>();
        countries.add(new Country("US", List.of("en")));
        countries.add(new Country("BE", Arrays.asList("nl", "fr", "de")));
        countries.add(new Country("NL", Arrays.asList("nl", "fy")));
        countries.add(new Country("DE", List.of("de")));
        countries.add(new Country("ES", List.of("es")));
        return countries;
    }
}