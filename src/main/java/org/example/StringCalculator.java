package org.example;

public class StringCalculator {
    public static int add(String input){
        if(!input.isEmpty()){
            // no code change needed this part of code automatically throws exception
            return Integer.parseInt(input);
        }
        return 0;
    }
}
