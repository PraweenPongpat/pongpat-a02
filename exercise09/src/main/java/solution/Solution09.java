/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution for exercise09
 *  Copyright 2021 Praween Pongpat
 */

package solution;

import java.util.Scanner;

public class Solution09 {
    /*
    * GIVEN THAT 1 GALLON COVER 350 SQ.FEET as a constant
    * create function getFeet, where the function takes in a String to prompt user appropriately
    *       - print the prompt to user
    *       - read user's input as double
    *       - return that double to its caller
    *
    * Program starts at main
    *   call function getFeet passing in "What is the length of the room? "
    *       - store the returned double in 'length'
    *   call function getFeet passing in "What is the width of the room? "
    *       - store the returned double in 'width'
    *   compute the following:
    *       - 'areaFeet' = 'length' * 'width'
    *       - 'numGallon' = 'areaFeet' / 'COVER_AREA_PER_GALLON'
    *               - the COVER_AREA_PER_GALLON is defined as a constant static final
    *               - if 'numGallon' is not perfectly divided, round up 'numGallon' to next integer via Math.Ceil()
    *   display output: "You will need to purchase xx gallons of paint to cover yy square feet"
    *       - where xx is the rounded (if any) 'numGallon', yy is 'areaFeet'
     */
    private static final int COVER_AREA_PER_GALLON = 350;
    private static final Scanner input = new Scanner(System.in);

    private double getFeet(String prompt){
        System.out.print(prompt);
        return Double.parseDouble(input.nextLine());
    }

    public static void main(String[] args) {
        Solution09 sol = new Solution09();

        double length = sol.getFeet("What is the length of the room? ");
        double width = sol.getFeet("What is the width of the room? ");

        double areaFeet = length * width;
        int numGallon = (int) Math.ceil(areaFeet/(double)COVER_AREA_PER_GALLON);

        System.out.printf("You will need to purchase %d gallon(s) of paint to cover %.1f square feet%n"
                            ,numGallon,areaFeet);
    }
}
