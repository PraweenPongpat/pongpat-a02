/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution for exercise11
 *  Copyright 2021 Praween Pongpat
 */

package solution;

import java.util.Scanner;

public class Solution11 {
    /*
    * GIVEN that curr_to/curr_from = exchangeRate
    *       this gives curr_to = exchangeRate * curr_from which will be used to calculate in this program
    *
    * create a function 'getDouble' where it takes in a string to prompt user
    *       - it will print the prompt to user
    *       - read a double from user
    *       - return that double to its caller
    * create a function 'roundIt' where it takes in a double
    *   if that double has any thousandth place decimal other than zero, round it up to next hundredth
    *       - use Math.ceil(xx*100)/100 to scope BOTH rounding up or down to the hundredth
    *       - the ceil function will round up that hundredth place
    *       - return the roundedNumber to its caller

    * program starts from main:
    *   call function 'getDouble' passing in the prompt "How many Euros are you exchanging? "
    *       - store the return double in 'amountEuro'
    *   call function passing 'getDouble' in the prompt "What is the exchange rate? "
    *       - store the return double in 'rate'
    *   perform calculations: 'amountDollar' = 'amountEuro' * 'rate'
    *   call 'roundIt' passing in 'amountDollar'
    *       - store the returned value in 'roundedAmountDollar'
    *   display outputs:
    *       - print "xx Euros at and exchange rate of yy is", where xx is 'amountEuros', yy is rate
    *       - print "xx U.S. dollars" where xx is 'roundedAmountDollar'
     */
    private static final Scanner input = new Scanner(System.in);

    private double getDouble (String prompt){
        System.out.print(prompt);
        return Double.parseDouble(input.nextLine());
    }

    private double roundIt (double original){
        return Math.ceil(original*100.00)/100.00;
    }

    public static void main(String[] args) {
        Solution11 sol = new Solution11();

        double amountEuro = sol.getDouble("How many Euros are you exchanging? ");
        double rate = sol.getDouble("What is the exchange rate? ");

        double amountDollar = sol.roundIt((amountEuro * rate));

        System.out.printf("%.2f Euros at an exchange rate of %.4f is%n%.2f U.S. dollars.%n"
                            ,amountEuro ,rate, amountDollar);
    }
}
