/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution for exercise18
 *  Copyright 2021 Praween Pongpat
 */

package solution;

import java.util.Locale;
import java.util.Scanner;

public class Solution18 {
    /*
     * create a function 'getString' that takes in a string to prompt user, return a string back to its caller
     *       -   display the prompt to user
     *       -   read a string from user
     *       -   return that string to its caller
     * create two functions that takes in a double, and return a double back to its caller
     *   first function 'CtoF', converting Celsius to Fahrenheit, thus it takes in Celsius
     *       -   calculate the Fahrenheit using 'F' = ('C' × 9 / 5) + 32
     *       -   return 'F' to its caller
     *   second function 'FtoC', converting Fahrenheit to Celsius, taking in Fahrenheit
     *       -   calculate the Celsius using 'C' = ('F' − 32) × 5 / 9
     *       -   return 'C' to its caller
     * create a function 'displayOutput' that takes in a String to prompt output, and a double to display in it
     *       -   prompt user for the output in passed in String and double
     *
     * Program starts here:
     *   call function 'getString' passing in "What unit would you like to convert to?
     *                                       (Press C for converting Fahrenheit to Celsius)
     *                                       (Press F for converting Celsius to Fahrenheit): "
     *      - store the return result in 'unit'
     *      - convert unit to lowercase, regardless of the input from user in order to solve case sensitivity
     *  determine if 'unit' is 'C' or 'F'
     *      - if 'unit' is 'c':
     *          - set 'flag1' to fahrenheit, set 'flag2' to celsius
     *      - if 'unit' is 'f':
     *          - set 'flag1' to celsius, set 'flag2' to fahrenheit
     *  call function 'getString' passing in a prompt context with 'flag1' to use in that context
     *          - i.e. with 'flag1' set to fahrenheit, pass in "Please enter temperature in fahrenheit: "
     *          - 'temperature' = convert the return string into double
     *  determine if 'unit' is 'C' or 'F'
     *      - if 'unit' is 'c': passing in 'temperature'
     *          - call 'fToC' function to convert, store return value in 'result'
     *      - if 'unit' is 'f': passing in 'temperature'
     *          - call 'cToF' function to convert, store return value in 'result'
     *  display output, via function 'displayOutput'
     *      - passing in the context and 'flag2',
     *          - i.e. "The temperature in Celsius is xx" where flag2 is Celsius and xx is 'result'
    */
    private static final Scanner input = new Scanner(System.in);

    private String getString(String prompt){
        System.out.print(prompt);
        return input.nextLine();
    }

    private double cToF(double c){
        return (c*9.0/5.0)+32.0;
    }

    private double fToC(double f){
        return (f-32.0)*5.0/9.0;
    }

    public static void main(String[] args) {
        Solution18 sol = new Solution18();

        String unit = sol.getString("""
                What unit would you like to convert to....
                1) Press C for converting Fahrenheit to Celsius
                2) Press F for converting Celsius to Fahrenheit
                Your choice?:""").toLowerCase(Locale.ROOT);

        String flag1 = (unit.equals("c"))? "Fahrenheit" : "Celsius";
        String flag2 = (unit.equals("c"))? "Celsius" : "Fahrenheit";

        double temperature = Double.parseDouble(sol.getString("Please enter temperature in " + flag1 + ": "));
        double result;

        if(unit.equals("c")){
            result = sol.fToC(temperature);
        } else {
            result = sol.cToF(temperature);
        }
        System.out.printf("The temperature in %s is %.2f%n", flag2, result);
    }
}
