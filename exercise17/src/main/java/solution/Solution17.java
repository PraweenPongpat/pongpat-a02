/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution for exercise17
 *  Copyright 2021 Praween Pongpat
 */

package solution;

import java.util.Scanner;

public class Solution17 {
    /*
    * GIVEN that the constant limit for men is 0.73, for women is 0.66 are fixed!
    * GIVEN that the constant legal BAC limit is 0.08.
    *
    * create a function 'getInt' where it takes in a string to prompt user, return integer to its caller
    *   - enter a loop where it only terminates if and only if user enters integer value
    *       - print the prompt to user
    *       - read a string from user
    *       - determine the string input from user if it is integer or not, using try,catch
    *           - try convert to integer, using Integer.parseInt(string)
    *               - if it works, that means user already enter integer, exit loop
    *               - if not, means user enter something other than integer, display catch message
    *                 to prompt user that it is not, restart the loop again
    *   - return that converted integer to its caller
    *
    * create a function 'getDouble' where it takes in a string to prompt user, return double to its caller
    *   - enter a loop where it only terminates if and only if user enters double value
    *       - print the prompt to user
    *       - read a string from user
    *       - determine the string input from user if it is double or not, using try,catch function
    *           - try convert to integer, using Double.parseDouble(string)
    *               - if it works, that means user already enter a double, exit loop
    *               - if not, means user enter something other than double, display catch message
    *                 to prompt user that it is not, restart the loop again
    *   - return that converted integer to its caller
    *
    * program starts here:
    *   call 'getInt' function, passing in "Enter1 if you are male, 2 if you are female: "
    *       - store the returned value in 'sex'
    *   call 'getDouble' function, passing in "How many ounces of alcohol did you have?: "
    *       - store the returned value in 'numOunce'
    *   call 'getDouble' function, passing in "What is your weight, in pounds?: "
    *       - store the returned value in 'weight'
    *   call 'getInt' function, passing in "How many hours has it been since your last drink?: "
    *       - store the returned value in 'numHours'
    *   check base on sex:
    *       if 'sex' is 1, means male, set 'limitBAC' = 0.73
    *       if 'sex' is 2, means female, set 'limitBAC' = 0.66
    *   perform calculations
    *       'BAC_Value' = ('numOunce' * 5.14 / 'weight'*'limit') - 0.015*'numHours'
    *   display output: "Your BAC is xx" where xx is BAC_Value
    *   determine if BAC_Value is less than LEGAL_LIMIT (0.08 for this exercise)
    *       - if so, display output "It is legal for you to drive."
    *       - if not, display output "It is NOT legal for you to drive."
     */

    public static int getInt(String prompt){
        Scanner input = new Scanner(System.in);
        String tempString;
        while(true){
            System.out.print(prompt);
            tempString = input.nextLine();
            try{
                return Integer.parseInt(tempString);
            }
            catch (NumberFormatException nfe){
                System.out.println("Please enter an integer number...");
            }
        }
    }

    public static double getDouble(String prompt){
        Scanner input = new Scanner(System.in);
        String tempString;
        while(true){
            System.out.print(prompt);
            tempString = input.nextLine();
            try{
                return Double.parseDouble(tempString);
            }
            catch (NumberFormatException nfe){
                System.out.println("Please enter a number...");
            }
        }
    }

    public static final double MAX_BAC_MALE = 0.73;
    public static final double MAX_BAC_FEMALE = 0.66;
    public static final double LEGAL_LIMIT = 0.08;

    public static void main(String[] args) {
        int sex = getInt("Enter: 1) if you're male, 2) if you are female: ");
        double numOunce = getDouble("How many ounces of alcohol did you have?: ");
        double weight = getDouble("What is your weight, in pounds?: ");
        int numHours = getInt("How many hours has it been since your last drink?: ");

        double limit = (sex==1)? MAX_BAC_MALE : MAX_BAC_FEMALE;
        double valueBAC = (numOunce * 5.14/weight * limit) - (0.015 * numHours);

        System.out.printf("Your BAC is %.6f%n", valueBAC);

        if (valueBAC < LEGAL_LIMIT){
            System.out.println("It is legal for you to drive.");
        } else {
            System.out.println("It is NOT legal for you to drive.");
        }
    }
}