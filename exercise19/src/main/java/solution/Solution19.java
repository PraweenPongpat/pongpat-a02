/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution for exercise19
 *  Copyright 2021 Praween Pongpat
 */

package solution;

import java.util.Scanner;

public class Solution19 {
    /*
    * create function 'getDouble', where it takes in a string to prompt user, return a double
    *   - display a prompt to user asking for the value
    *   - read double from integer, implement 'try' and 'catch' in case user enter non-numerical data
    *       - try: read the data as double, if no error occurs, call function 'isValid'
    *           - if 'isValid' passes, return that double to its caller
    *           - if 'isValid' do not pass, prompt user "please enter valid value", start over
    *       - catch: only when error occurred, meaning user entered non-numerical
    *           - display "please enter numerical number", start asking again from the beginning
    * create function 'isValid' where it takes in a double, return Boolean
    *   - check if the passed in double > 0.00
    *       - if so: return 1 to its caller
    *       - if not: return 0 to its caller
    * create function 'findBMI' where it takes in two doubles, height and weight
    *   - calculate (weight / (height × height)) * 703
    *   - return the calculated value to its caller
    *
    * program start here:
    *   call function 'getDouble', passing in "height"
    *       - in the 'getDouble' will also call function 'isValid' to check for its validation
    *       - store the returned value to 'height'
    *   call function 'getDouble', passing in "weight"
    *       - with same concepts, store the returned value in 'weight'
    *   call function 'findBMI', passing in 'height' and 'weight'
    *       - store the return value in 'BMI'
    *   determine BMI value using if/else_if/else statement
    *       - if BMI is less than 18.5; prompt user showing underweight context
    *       - else if BMI is between 18.5 to 25; prompt user showing being healthy
    *       - else if BMI is over 25; prompt user showing overweight context, see doctor
     */

    public static double getDouble(String prompt){
        boolean valid = false;
        double data = 0.00;
        Scanner input = new Scanner(System.in);
        do{
            System.out.print("What is your " + prompt + "?: ");
            try{
                data = Double.parseDouble(input.nextLine());
            }
            catch (NumberFormatException nfe){
                System.out.println("Please re-enter with numerical value");
                continue;
            }
            valid = isValid(data);
        }while(!valid);
        return data;
    }

    public static boolean isValid(double data){
        if(data>0.00){
            return true;
        } else{
            System.out.println("Please re-enter with positive value.");
            return false;
        }
    }

    public static double findBMI(double height, double weight){
        return (weight / (height * height)) * 703;
    }

    public static void main(String[] args) {
        double height = getDouble("height");
        double weight = getDouble("weight");

        double result = findBMI(height, weight);
        String output;
        if(result<18.5)
            output = "You're underweight, need to eat!";
        else if(result>=18.5 && result<=25)
            output = "You're healthy! According to BMI score!";
        else
            output = "You're overweight, cut down dessert!";

        System.out.printf("Your BMI is %.1f%n%s%n", result, output);
    }
}
