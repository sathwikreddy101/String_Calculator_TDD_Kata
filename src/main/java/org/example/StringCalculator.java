package org.example;

public class StringCalculator {
    public static int add(String input){
        if(!input.isEmpty()){
            if(input.length() == 1){
                return Integer.parseInt(input);
            }
            int sum = 0;
            String[] numbers = input.split(",");
            sum += Integer.parseInt(numbers[0].trim());
            sum += Integer.parseInt(numbers[1].trim());
            return sum;
        }
        return 0;
    }
}
