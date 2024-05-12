package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int add(String input){
        if(!input.isEmpty()){
            return sum(input);
        }
        return 0;
    }

    private static int sum(String input){
        List<Integer> numbers = getIntegerListFromString(split(input));
        checkNegatives(numbers);
        return numbers.stream()
                .reduce(Integer::sum)
                .orElseThrow();
    }

    private static void checkNegatives(List<Integer> numbers) {
        StringBuilder negativeNumbers = new StringBuilder();
        numbers.stream()
                .filter(num -> num < 0)
                .forEach(num -> negativeNumbers.append(num).append(" "));
        if(!negativeNumbers.toString().isEmpty()){
            throw new RuntimeException("negative numbers not allowed " + negativeNumbers);
        }
    }

    private static List<Integer> getIntegerListFromString(String[] strings) {
        return Arrays.stream(strings)
                .filter(str -> !str.isEmpty())
                .map(Integer::parseInt)
                .toList();
    }

    private static String[] split(String input) {
        if(input.startsWith("//")){
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
            if(matcher.matches()){
                String delimiter = matcher.group(1);
                String toSplit = matcher.group(2);
                return toSplit.split(delimiter);
            }
            throw new RuntimeException("Wrong Custom Delimiter");
        }
        return input.split("(?<!,)\\s*(,|\\n)");
    }
}
