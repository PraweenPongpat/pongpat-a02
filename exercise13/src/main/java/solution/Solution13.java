/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution for exercise13
 *  Copyright 2021 Praween Pongpat
 */

package solution;

import java.util.Scanner;

public class Solution13 {
    /*
    * create a function 'getDouble' which takes in a string to prompt to user:
    *       - display the prompt to user
    *       - read a double from user
    *       - return that double back to its caller
    * create a function 'getInt' which takes in a string to prompt to user:
     *       - display the prompt to user
     *       - read an int from user
     *       - return that int back to its caller
     * create a function 'roundIt' where it takes in a double
     *   if that double has any thousandth place decimal other than zero, round it up to next hundredth
     *       - use Math.ceil(xx*100)/100 to scope rounding up to the hundredth
     *       - return the roundedNumber to its caller
     *
     * program starts here:
     *  call 'getDouble' passing in "What is the principal amount?: "
     *      - store the returned value in 'principal'
     *  call 'getDouble' passing in "What is the rate (in percent)?: "
     *      - store the returned value in 'rate'
     *  call 'getInt' passing in "What is the number of years (in integer value)?: "
     *      - store the returned value in 'duration'
     *  call 'getInt' passing in "What is the number of times the interest is compounded per year?: "
     *      - store the returned value in 'compoundPerYear'
     *  Compute the following:
     *      - 'rate' /= 100 :   to convert percents into fraction
     *      - 'total' = 'principal' * (1 + (rate/compoundPerYear))^(compoundPerYear*duration)
     *              - to calculate power, use Math.pow(xx,yy) from Math class in API
     *  call 'roundIt' function, passing in 'total'
     *      - store the returned value in 'roundedTotal'
     *  display outputs:
     *      - print "$vv invested at ww% for xx years compounded yy times per year is $zz"
     *          where vv = principal, ww = rate in percent, xx = duration, yy = compoundPerYear, zz = roundedTotal
     */

    public static double getDouble (String prompt){
        System.out.print(prompt);
        Scanner input = new Scanner(System.in);
        return input.nextDouble();
    }

    public static int getInt (String prompt){
        System.out.print(prompt);
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public static double roundIt (double original){
        return Math.ceil(original*100.00)/100.00;
    }

    public static void main(String[] args) {
        double principal = getDouble("What is the principal amount?: ");
        double rate = getDouble("What is the rate (in percent)?: ");

        int duration = getInt("What is the number of years (in integer)?: ");
        int compoundPerYear = getInt("What is the number of times the interest is compounded per year?: ");

        rate /= 100.00;
        double total = roundIt(principal * (Math.pow(1+(rate/compoundPerYear),(double) compoundPerYear*duration)));

        System.out.printf("$%.2f invested at %.2f%% for %d years compounded %d times per year is $%.2f%n"
                            , principal, rate*100, duration, compoundPerYear ,total);

    }
}
