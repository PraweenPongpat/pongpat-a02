/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution for exercise10
 *  Copyright 2021 Praween Pongpat
 */

package solution;

import java.util.Scanner;

public class Solution10 {
    /*
    * GIVEN: that there are FIXED three items in buying today, given from the exercise's problem
    *       must create a constant NUM_ITEM_BUYING
    * GIVEN: the tax rate is a constant 5.5%, must create a constant TAX_RATE
    *
    * create a function getPrice, where the function takes in an integer that represent item_number
    *       - prompt user asking for the price of the item
    *       - read string from user
    *       - convert that string into double
    *       - return the double to its caller
    * create a function howMany, where the function takes in an integer that represent item_number
    *       - prompt user asking for the quantities of that item
    *       - read string from user
    *       - convert that string into integer
    *       - return the integer to its caller
    *
    * start program in main:
    *   create two arrays: (prices and quantities) both being int arrays with size of NUM_ITEM_BUYING
    *   create a loop that runs up to NUM_ITEM_BUYING times, inside this loop, it will
    *       - prices[index] = call function getPrice, passing in current loop number
    *       - quantities[index] = call function howMany, passing in current loop number
    *   create a separate loop runs up to NUM_ITEM_BUYING times, where each iteration will
    *       - 'priceBeforeTax' += (prices[index]*quantities[index])
    *   compute 'tax' = 'totalPrice'*TAX_RATE/100
    *   compute 'priceAfterTax' = 'priceBeforeTax' + 'tax'
    *   build strings:
    *       - 'subtotalOutput' = "Subtotal: $xx", where xx is 'priceBeforeTax'
    *       - 'taxOutput' = "Tax: $xx", where xx is 'tax'
    *       - 'totalOutput' = "Total: $xx", where xx is 'priceAfterTax'
    *   display outputs:
    *       - print 'subtotalOutput'
    *       - print "taxOutput'
    *       - print "totalOutput'
    */

    //defining constants
    public static final int NUM_ITEM_BUYING = 3;
    public static final double TAX_RATE = 5.5;

    public static double getPrice(int index){
        System.out.printf("Enter the price of item %d: ", index);
        Scanner input = new Scanner(System.in);
        return Double.parseDouble(input.nextLine());
    }

    public static int howMany(int index){
        System.out.printf("Enter the quantity of item %d: ", index);
        Scanner input = new Scanner(System.in);
        return Integer.parseInt(input.nextLine());
    }

    public static void main(String[] args) {
        //create arrays
        double[] prices = new double[NUM_ITEM_BUYING];
        int[] quantities = new int[NUM_ITEM_BUYING];

        //get input
        for(int i=0; i<NUM_ITEM_BUYING; i++){
            prices[i] = getPrice(i+1);
            quantities[i] = howMany(i+1);
        }

        //perform calculation
        double priceBeforeTax = 0.00;
        for(int j=0; j<NUM_ITEM_BUYING; j++){
            priceBeforeTax += (prices[j]*quantities[j]);
        }
        double tax = priceBeforeTax * TAX_RATE/100;
        double priceAfterTax = priceBeforeTax + tax;

        //build Strings
        String subtotalOutput = "Subtotal: $" + priceBeforeTax;
        String taxOutput = "Tax: $" + tax;
        String totalOutput = "Total: $" + priceAfterTax;

        //display output
        System.out.println(subtotalOutput);
        System.out.println(taxOutput);
        System.out.println(totalOutput);
    }
}