package org.example;

public class StringCalculator {
    public static int add(String input){
        if(!input.isEmpty()){
            return sum(input);
        }
        return 0;
    }

    private static int sum(String input){
        if(input.length() == 1){
            return Integer.parseInt(input);
        }
        int sum = 0;
        String[] numbers = input.split(",");
        sum += Integer.parseInt(numbers[0].trim());
        sum += Integer.parseInt(numbers[1].trim());
        return sum;
    }
}
