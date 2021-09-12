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
     *       - use Math.round(xx*100)/100 to scope BOTH rounding up or down to the hundredth
     *       - compare the rounded number, and original number
     *       - if 'roundedNumber' < 'originalNumber' means it's rounded down
     *                   - 'roundedNumber += 0.01,   force it to round up
     *       - other cases if they are equal, or greater, do no adjustment to it
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
        double rounded = (double) Math.round(original*100)/100;
        if(rounded < original){
            rounded += 0.01;
        }
        return rounded;
    }

    public static void main(String[] args) {
        double principal = getDouble("What is the principal amount?: ");
        double rate = getDouble("What si the rate (in percent)?: ");

        int duration = getInt("What is the number of years (in integer)?: ");
        int compoundPerYear = getInt("What is the number of times the interest is compounded per year?: ");

        rate /= 100;
        double total = principal * (Math.pow(1+(rate/compoundPerYear),(double) compoundPerYear*duration));

        double roundedTotal = roundIt(total);

        System.out.printf("$%.2f invested at %.2f%% for %d years compounded %d times per year is $%.2f%n"
                            , principal, rate*100, duration, compoundPerYear ,roundedTotal);

    }
}
