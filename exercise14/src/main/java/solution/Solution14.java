/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution for exercise14
 *  Copyright 2021 Praween Pongpat
 */

package solution;

import java.util.Scanner;

public class Solution14 {
    /*
    * GIVEN that WI is the only state baseline exercise aim to detect
    * GIVEN that the %tax is fixed to 5.5%
    *
    * create a function 'getTax' which it will take in two doubles represent amount, and TAX_RATE to tax from
    *   - make a double = 'amount' * TAX_RATE/100
    *   - return the newly calculated double
    * create a function 'roundIt' which takes in a double
    *   - use Math.ceil(xx*100.00)/100.00 to scope round up to the hundredth place
    *   - return the value to its caller
    *
    * program starts here:
    *   prompt user "What is the order amount? " to get double
    *   'amount' = read double from user input
    *   prompt user "What is the state? " to get string
    *   'state' = read string from user input
    *   set output string concatenation
    *       'outputString' = "The total is $" + amount
    *   use string1.equal(string2) to compare 'state' and 'FOCUS_STATE'
    *       - FOCUS_STATE must be defined as a constant string as static final, it is "WI" for this example
    *   determine the returned value
    *       - return value from .equal is true, means the input state is the same as FOCUS_STATE,
    *           - call function 'getTax'
    *               - store value in 'taxAmount'
    *           - 'total' = 'amount' + 'taxAmount'
    *           - call function 'roundIt' passing in 'total'
    *               - store the returned value back in total
    *           - set output string using string concatenation
    *               - 'outputString' =  "The subtotal is $xx    --> xx is amount
    *                                    The tax is $yy         --> yy is taxAmount from 'getTax'
    *                                    The total is $zz"      --> zz is 'total'
    *       - return value is otherwise, means the input state is not FOCUS_STATE, do nothing for it
    *   display output: print out 'stringOutput' to user

     */
    private static final Scanner input = new Scanner(System.in);
    private static final String FOCUS_STATE = "WI";
    private static final Double TAX_RATE = 5.5;

    private double getTax(double amount, double rate){
        return amount*rate/100.00;
    }

    private double roundIt(double amount){
        return Math.ceil(amount*100.00)/100.00;
    }

    public static void main(String[] args) {
        Solution14 sol = new Solution14();

        //prompt user and get double input
        System.out.print("What is the order amount?: ");
        double amount = Double.parseDouble(input.nextLine());

        //prompt user and get string input
        System.out.print("What is the state?: ");
        String state = input.nextLine();

        //string concatenate before if statement
        String stringOutput = String.format("The total is $%.2f%n",(amount*100.00/100.00));

        //if statement to determine if input is the same as WI
        if(state.equals(FOCUS_STATE)){
            double taxAmount = sol.getTax(amount,TAX_RATE);
            double total = sol.roundIt(amount + taxAmount);

            //update string with new context on it
            stringOutput = String.format("The subtotal is $%.2f%nThe tax is $%.2f%nThe total is $%.2f%n",
                                            amount , taxAmount ,total);
        }
        //display output
        System.out.print(stringOutput);
    }
}
