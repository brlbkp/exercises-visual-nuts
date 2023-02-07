package com.brunolima.exerciseone;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExerciseOneTest {


    @Test
    void testDivisibleBy3() {
        ExerciseOne exerciseOne = new ExerciseOne("Visual", "Nuts");
        List<String> items = exerciseOne.generateList(10);

        assertEquals("Visual", items.get(2));
        assertEquals("Visual", items.get(5));
        assertEquals("Visual", items.get(8));
    }

    @Test
    void testDivisibleBy5() {
        ExerciseOne exerciseOne = new ExerciseOne("Visual", "Nuts");
        List<String> items = exerciseOne.generateList(10);

        assertEquals("Nuts", items.get(4));
        assertEquals("Nuts", items.get(9));
    }

    @Test
    void testDivisibleBy3and5() {
        ExerciseOne exerciseOne = new ExerciseOne("Visual", "Nuts");
        List<String> items = exerciseOne.generateList(30);

        assertEquals("Visual Nuts", items.get(14));
        assertEquals("Visual Nuts", items.get(29));
    }

    @Test
    void testNotDivisibleBy3Or5() {
        ExerciseOne exerciseOne = new ExerciseOne("Visual", "Nuts");
        List<String> items = exerciseOne.generateList(15);

        assertEquals("1", items.get(0));
        assertEquals("7", items.get(6));
        assertEquals("13", items.get(12));
    }
}