/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution for exercise16
 *  Copyright 2021 Praween Pongpat
 */

package solution;

import java.util.Scanner;

public class Solution16 {
    /*
    * GIVEN that the legal driving age is 16 as a fixed constant
    *
    * create a function 'getInt' where it takes in a string prompt, return int to its caller
    *   - display prompt string to user
    *   - read integer from user
    *   - return that integer to its caller
    *
    * program starts here:
    *   call function 'getInt' passing in "What is your age?: "
    *       - store the returned value in 'age'
    *   determine 'age' >= 'DRIVING_AGE'?
    *       if so, set string to "You are old enough to legally drive."
    *       if not, set string to "You are not old enough to legally drive."
     */
    private static final Scanner input = new Scanner(System.in);
    private static final int DRIVING_AGE = 16;

    private int getInt(String prompt){
        System.out.print(prompt);
        return Integer.parseInt(input.nextLine());
    }

    public static void main(String[] args) {
        Solution16 sol = new Solution16();

        int age = sol.getInt("What is your age?: ");
        String output = (age>=DRIVING_AGE) ?
                "You are old enough to legally drive." : "You are not old enough to legally drive.";
        System.out.println(output);
    }
}
