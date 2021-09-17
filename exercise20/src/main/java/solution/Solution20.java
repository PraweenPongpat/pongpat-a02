/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution for exercise20
 *  Copyright 2021 Praween Pongpat
 */

package solution;

import java.util.Scanner;

public class Solution20 {
    /*
    * set all CONSTANT(s) given for this example
    * need to set constant for base tax rate of WI, 'BASE_RATE_WI' to 5%
    * need to set constant for base tax rate of IL, 'BASE_RATE_IL' to 8%
    * need to set constant for additional for WI in Eau Claire, 'ADDITION_WI_EAU_CLAIRE' = 0.5%
    * need to set constant for additional for WI in Dunn, 'ADDITION_WI_DUNN' = 0.4%
    *
    * create a function 'getAmount' takes in nothing, return a double
    *   - display a prompt "What is the order amount?: " to user for the double input
    *   - read the user's double input
    *   - return the double read from user to its caller
    * create a function 'getString' passing in a string prompt and return a string
    *   - display a prompt to user for the sting input
    *   - read the user's string input
    *   - return the sting input to its caller
    * create a function 'getTaxRate' to determine the tax rate being charge, passed in two strings state,county
    *   - base on state:
    *       - if 'state' is WI, check further for its county
    *           - if 'county' is Eau Claire, calculate 'taxRate' = BASE_RATE_WI + ADDITION_WI_EAU_CLAIRE
    *           - if 'county' is Dunn, calculate 'taxRate' = BASE_RATE_WI + ADDITION_WI_DUNN
    *           - return 'taxRate' to its caller
    *       - if 'state' is IL, set 'taxRate' to BASE_RATE_IL
    *           - return 'taxRate' to its caller
    *       - if it's any other states, return 0.00 to its caller
    *
    * program starts here:
    *   call function getDouble passing in prompt "What is the order amount?: "
    *       - store the returned value in 'amount'
    *   call function getString passing in prompt "state"
    *       - store the returned value in 'state'
    *   call function getString passing in prompt "county"
    *       - store the return value in 'county'
    *   call function 'getTaxRate' passing in 'state' and 'county'
    *       - store the return value in 'taxRate'
    *   calculate:
    *       - 'taxValue' = 'amount' * 'taxRate'/100.00
    *       - 'totalAmount' = 'amount' + 'taxValue'
    *   display outputs:
    *       - "The tax is xx" where xx is 'taxValue'
    *       - "The total is xx" where xx is 'totalAmount'
     */

    //define constants given
    private static final double BASE_RATE_WI = 5.00;
    private static final double BASE_RATE_IL = 8.00;
    private static final double ADDITION_WI_EAU_CLAIRE = 0.50;
    private static final double ADDITION_WI_DUNN = 0.4;
    private static final Scanner input = new Scanner(System.in);

    private double getAmount(){
        System.out.print("What is the order amount?: ");
        return Double.parseDouble(input.nextLine());
    }

    private String getString(String keyword){
        System.out.print("What " + keyword + " do you live in?: ");
        return input.nextLine();
    }

    private double getTaxRate(String state, String county){
        double taxRate = 0.00;
        if (state.equals("WI") || state.equals("Wisconsin")){
            taxRate = BASE_RATE_WI;
            if(county.equals("Eau Claire")){
                taxRate += ADDITION_WI_EAU_CLAIRE;
            }
            else if(county.equals("Dunn")){
                taxRate += ADDITION_WI_DUNN;
            }
        }
        else if(state.equals("IL") || state.equals("Illinois")){
            taxRate = BASE_RATE_IL;
        }
        return taxRate;
    }

    private double roundIt(double amount){
        return Math.ceil(amount*100.00)/100.00;
    }

    public static void main(String[] args) {
        Solution20 sol = new Solution20();

        //takes in inputs
        double amount = sol.getAmount();
        String state = sol.getString("state");
        String county = sol.getString("county");

        //calculations
        double taxRate = sol.getTaxRate(state,county);
        double taxAmount = sol.roundIt(amount * taxRate/100.00);
        double totalPrice = amount + taxAmount;

        //display output
        System.out.printf("The tax is $%.2f.%nThe total is $%.2f.%n", taxAmount, totalPrice);
    }

}
