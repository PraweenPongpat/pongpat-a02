/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution for exercise06
 *  Copyright 2021 Praween Pongpat
 */

package solution;

import java.time.LocalDate;
import java.util.Scanner;

public class Solution06 {
    // call function 'getAge' passing in a prompt where in the function will
    //      print (prompt) user to get input of user's 'currentAgeString' in string
    //      ask user for input, store as String
    //      convert that String into int with Integer.parseInt(...)
    //      return int to caller, store as 'currentAge'
    // call the same function 'getAge', passing another prompt
    //      print (prompt) user to get input of user's 'retireAgeString' in string
    //      ask user for input, store as String
    //      convert that String into int with Integer.parseInt(...)
    //      return int to caller, store as 'retireAge'
    // perform calculation
    //      int 'thisYear' = get current year from .time.LocalDate API class
    //      int 'workingYear' = 'retireAge' - 'currentAge'
    //      int 'retireYear' = 'thisYear' + 'workingYear'
    // print output to screen
    //      print "you have xx years left until you can retire" via 'workingYear'
    //      print "It's xx, so you can retire in yy" via 'thisYear' and 'retireYear'

    private static final Scanner input = new Scanner(System.in);

    private int getAge(String prompt){
        System.out.print(prompt);
        return Integer.parseInt(input.nextLine());
    }

    public static void main(String[] args) {
        Solution06 sol = new Solution06();

        int currentAge = sol.getAge("What is your current age? ");

        int retireAge = sol.getAge("At what age would you like to retire? ");

        LocalDate today = LocalDate.now();
        int thisYear = today.getYear();

        int workingYear = retireAge - currentAge;
        int retireYear = thisYear + workingYear;

        System.out.println("You have " + workingYear + " years left until you can retire.\n"
                            + "It's " + thisYear + ", so you can retire in " + retireYear);
    }
}
