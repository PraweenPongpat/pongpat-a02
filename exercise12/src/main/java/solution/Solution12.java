/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution for exercise12
 *  Copyright 2021 Praween Pongpat
 */

package solution;

import java.util.Scanner;

public class Solution12 {
    /*
    * create a function 'getDouble' that takes in a string to prompt user, where the function will
    *       - print the prompt to user
    *       - read double input from user
    *       - return that double to its caller
    * create a function 'roundIt' where it takes in a double
    *   if that double has any thousandth place decimal other than zero, round it up to next hundredth
    *       - use Math.ceil(xx*100)/100 to scope rounding up to the hundredth
    *       - return the roundedNumber to its caller

    * Program starts here:
    *   call getDouble function, passing in "Enter the principal: "
    *       - store the returned value in 'principal'
    *   call getDouble function, passing in "Enter the rate of interest (in percent): "
    *       - store the returned value in 'rate'
    *   call getDouble function, passing in "Enter the number of years: "
    *       - store the returned value in 'duration'
    *   perform calculation
    *       - 'rate' = 'rate'/100 : convert 'rate' to fraction from percent
    *       - 'total' = 'principal' * (1 + ('rate' * 'duration'))
     *  call 'roundIt' passing in 'total'
     *       - store the returned value in 'roundedTotal'
    *   display outputs:
    *       - "After xx years at yy%, the investment will be worth $zz"
    *           where xx = 'duration', yy = rate', zz = 'roundedTotal'
     */

    public static double getDouble(String prompt){
        System.out.print(prompt);
        Scanner input = new Scanner(System.in);
        return input.nextDouble();
    }

    public static double roundIt (double original){
        return Math.ceil(original*100.0)/100.0;
    }

    public static void main(String[] args) {
        double principal = getDouble("Enter the principal: ");
        double rate = getDouble("Enter the rate of interest (in percent): ");
        double duration = getDouble("Enter the number of years: ");

        rate /= 100.00;
        double total = roundIt(principal*(1+(rate*duration)));

         System.out.printf("After %.0f years at %.2f%%, the investment will br worth $%.2f.%n"
                            , duration, rate*100, total);
    }
}
