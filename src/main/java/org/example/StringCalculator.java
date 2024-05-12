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
        List<Integer> numbers = Arrays.stream(input.split(",|\n"))
                .map(Integer::parseInt)
                .toList();
        return numbers.stream()
                .reduce(Integer::sum)
                .orElseThrow();
    }
}
