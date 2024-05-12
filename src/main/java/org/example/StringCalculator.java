package org.example;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    public static int add(String input){
        if(!input.isEmpty()){
            return sum(input);
        }
        return 0;
    }

    private static int sum(String input){
        List<Integer> numbers = getIntegerListFromString(split(input));
        return numbers.stream()
                .reduce(Integer::sum)
                .orElseThrow();
    }

    private static List<Integer> getIntegerListFromString(String[] strings) {
        return Arrays.stream(strings)
                .filter(str -> !str.isEmpty())
                .map(Integer::parseInt)
                .toList();
    }

    private static String[] split(String input) {
        return input.split("(?<!,)\\s*(,|\\n)");
    }
}
