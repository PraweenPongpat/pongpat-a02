/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution for exercise21
 *  Copyright 2021 Praween Pongpat
 */

package solution;

import java.util.Scanner;

public class Solution21 {
    /*
    * create a function 'getNumMonth' where it takes in nothing
    *   - display a prompt to user "Please enter the number of month: "
    *   - read an integer from user
    *   - return the integer input to its caller
    * create a function 'checkMonth' where it takes in an integer, return a string
    *   - determine the integer input:
    *       if it is 1: set 'string' = January
    *       if it is 2: set 'string' = February
    *       if it is 3: set 'string' = March
    *       ...
    *       if it is 12: set 'string' = December
    *   - return the string to is caller
    *
    * program starts here:
    *   Loop starts: use a 'flag' to terminate the loop, if 'flag' is false means no more next iteration
    *       call function 'getInt'
    *           - store the return integer in 'numMonth'
    *       determine if 'numMonth' is in range of 1 to 12, inclusive
    *           if so: call function 'checkMonth'
    *               - store the return to 'result'
    *               - build string "The name of the month is xx" where xx is 'result'
    *               - set 'flag' to false, no more next iteration
    *           if not: set 'result' = "You have entered the non-existing month, it's only 1 to 12!"
    *       output:
    *           - display string store in 'result'
    *   as long as flag doesn't set to false, the loop doesn't end
    */
    private static final Scanner input = new Scanner(System.in);

    private int getNumMonth (){
        System.out.print("Please enter the number of the month: ");
        return Integer.parseInt(input.nextLine());
    }

    private String checkMonth(int numMonth){
        return switch (numMonth) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> "";
        };
    }

    public static void main(String[] args) {
        Solution21 sol = new Solution21();

        String result;
        boolean flag = true;

        while(flag){
            int numMonth = sol.getNumMonth();

            if(numMonth>=1 && numMonth<=12){
                result = "The name of the month is: " + sol.checkMonth(numMonth);
                flag = false;
            } else {
                result = "You have entered the non-existing month, it's only 1 to 12... try again";
            }
            System.out.println(result);
        }
    }
}
