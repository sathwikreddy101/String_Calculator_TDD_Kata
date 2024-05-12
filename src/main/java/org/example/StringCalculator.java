package org.example;

public class StringCalculator {
    public static int add(String input){
        if(!input.isEmpty()){
            return Integer.parseInt(input);
        }
        return 0;
    }
}
