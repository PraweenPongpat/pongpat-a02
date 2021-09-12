/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution for exercise15
 *  Copyright 2021 Praween Pongpat
 */

package solution;

import java.util.Scanner;

public class Solution15 {
    /*
    * create a function 'getString' that takes in a prompt from user, and return the string
    *   - print the string prompt to user asking for a string input
    *   - read the string input from user
    *   - return that input to its caller
    *
    * program starts here:
    *   call function 'getString' passing in "What is the username?: "
    *       - since the program do not care about username, no need to store it
    *   call function 'getString' passing in "What is the password?: "
    *       - store the returned value in 'password'
    *   compare if 'password' is the same as pre-defined constant PASSWORD
    *       - if it is the same:
    *           output "Welcome!"
    *       - if it is not the same:
    *           output "I don't know you."
     */

    public static String getString(String prompt){
        System.out.print(prompt);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
    public static final String PASSWORD = "abc$123";
    public static void main(String[] args) {
        getString("What is the username?: ");
        String password = getString("What is the password?: ");

        if(password.equals(PASSWORD)){
            System.out.println("Welcome!");
        } else{
            System.out.println("I don't know you.");
        }
    }
}
