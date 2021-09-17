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
    private static final Scanner input = new Scanner(System.in);
    private static final String PASSWORD = "abc$123";

    private String getString(String prompt){
        System.out.print("What is the " + prompt + "?: ");
        return input.nextLine();
    }

    private boolean passwordValidator(String password){
        return password.equals(PASSWORD);
    }

    public static void main(String[] args) {
        Solution15 sol = new Solution15();

        sol.getString("username");
        String password = sol.getString("password");

        String response;
        if(sol.passwordValidator(password)){
            response = "Welcome!";
        } else{
            response = "I don't know you.";
        }

        System.out.println(response);
    }
}
