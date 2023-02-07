package com.brunolima;

import com.brunolima.exerciseone.ExerciseOne;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ExerciseOne exerciseOne = new ExerciseOne("Visual", "Nuts");
        List<String> items = exerciseOne.generateList(10);
        items.forEach(System.out::println);
    }
}