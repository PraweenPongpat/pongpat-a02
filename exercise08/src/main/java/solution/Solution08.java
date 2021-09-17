/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution for exercise08
 *  Copyright 2021 Praween Pongpat
 */

package solution;

import java.util.Scanner;

public class Solution08 {
    /*
    * create function to getInt, where function takes in a string to prompt to user appropriately
    *       - print prompt string to user
    *       - get integer from user
    *       - return that integer to its caller
    *
    * program starts at main
    *   call function getInt, passing the prompt "How many people? "
    *       - store the return value in 'numPeople'
    *   call function getInt, passing the prompt "How many pizzas do you have? "
    *       - store the return value in 'numPizza'
    *   call function getInt, passing the prompt "How many slices per pizza? "
    *       - store the return value in 'slicePerPizza'
    *   compute the following:
    *       - 'totalSlice' = 'numPizza' * 'slicePerPizza', find total number of slices we have
    *       - 'sliceEach' = 'totalSlice' / 'numPeople', to find out how many slice each person can have
    *       - 'remainSlice' = 'totalSlice' mod 'numPeople', find leftover in pizza tray(s)
    *   display output to user:
    *       - print "xx people with yy pizza (zz slices)" where xx='numPeople', yy='numPizza', zz='totalSlice'
    *       - print "Each person gets xx pieces of pizza" where xx='sliceEach'
    *       - print "There are xx leftover pieces" where xx=remainSlice
     */
    private static final Scanner input = new Scanner(System.in);

    private int getInt(String prompt){
        System.out.print(prompt);
        return Integer.parseInt(input.nextLine());
    }

    public static void main(String[] args) {
        Solution08 sol = new Solution08();

        int numPeople = sol.getInt("How many people? ");
        int numPizza = sol.getInt("How many pizza do you have? ");
        int slicePerPizza = sol.getInt("How many slices per pizza? ");

        int totalSlices = numPizza*slicePerPizza;
        int sliceEach = totalSlices/numPeople;
        int remainSlice = totalSlices%numPeople;

        System.out.println(numPeople + " people with " + numPizza + " pizzas (" + totalSlices + " slices)");
        System.out.println("Each person gets " + sliceEach + " pieces of pizza.");
        System.out.println("There are " + remainSlice + " leftover pieces");
    }
}
