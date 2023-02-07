package com.brunolima.exerciseone;

import java.util.LinkedList;
import java.util.List;

public class ExerciseOne {

    private final String firstWord;
    private final String secondWord;
    private final String allWords;

    public ExerciseOne(String firstWord, String secondWord) {
        this.firstWord = firstWord;
        this.secondWord = secondWord;
        this.allWords = firstWord + " " + secondWord;
    }

    public List<String> generateList(int limit) {
        List<String> result = new LinkedList<>();

        for (int i = 1; i <= limit; i++) {
            boolean isDivByThree = isDivisible(i, 3);
            boolean isDivByFive = isDivisible(i, 5);

            if (isDivByThree && isDivByFive) {
                result.add(this.allWords);
            } else if (isDivByThree) {
                result.add(this.firstWord);
            } else if (isDivByFive) {
                result.add(this.secondWord);
            } else {
                result.add(String.valueOf(i));
            }
        }

        return result;
    }

    private boolean isDivisible(int dividend, int divisor) {
        return (dividend % divisor == 0);
    }
}
