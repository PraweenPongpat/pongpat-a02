/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution for exercise07
 *  Copyright 2021 Praween Pongpat
 */

package solution;

import java.util.Scanner;

public class Solution07 {
    /*
    * create a function that passed in a prompt string, in that function, it will
    *   print the prompt string
    *   get input from user as a double
    *   return that double to its caller
    *       this function will be use as many times as needed
    *
    * create a function that passed in length and width to convert sqFeetToSqMeters, in that function, it will
    *   compute a double = length * width * constantConversion
    *       where constant conversion is 0.09290304 as static final type
    *
    * program starts from main
    *   call function, passing in prompt "What is the length of the room in feet? "
    *       store the returned value in 'length'
    *   call function, passing in prompt "What is the width of the room in feet? "
    *       store the returned value in 'width'
    *   calculate the area in square feet via 'areaFeet' = 'length' * 'width'
    *   calculate the area in square meters use the function 'sqFeetToSqMeters'
    *       passing in 'areaFeet' to the function and store return value in 'areaMeters'
    *   display output to user
    *       values that user gave in the correct context of "xx by yy" feet
    *       "xx square feet" where xx is 'areaFeet'
    *       display "yy square meters" where yy is 'areaMeters'
     */

    static final double CONSTANT_CONVERSION = 0.09290304;

    public static double getFeet(String prompt){
        System.out.print(prompt);
        Scanner input = new Scanner(System.in);
        return input.nextDouble();
    }

    public static double sqFeetToSqMeters(double length, double width){
        return length*width*CONSTANT_CONVERSION;
    }

    public static void main(String[] args) {
        double length = getFeet("What is the length of the room in feet? ");
        double width = getFeet("What is the width of the room in feet? ");

        double areaFeet = length * width;
        double areaMeters = sqFeetToSqMeters(length,width);

        System.out.println("You entered dimensions of " + length +" feet by " + width + " feet.");
        System.out.println("The area is");
        System.out.printf("%.3f square feet%n",areaFeet);
        System.out.printf("%.3f square meters%n", areaMeters);
    }
}
