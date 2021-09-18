/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution for exercise23
 *  Copyright 2021 Praween Pongpat
 */

package solution;

import java.util.Locale;
import java.util.Scanner;

public class Solution23 {
    /*
    * create function 'isYes' takes in a string return boolean
    *   - this is auxiliary function to determine whether the string is Yes or Y (can be mixed upper/lower case)
    *   - return true if it's a yes
    *   - return false if it's a no
    * create function 'isNoiseWhenKeyIn' takes in nothing, return string
    *   - display prompt to user asking "Is the car silent when you turn the key?: "
    *   - read string from user
    *   - call 'isYes' on user's input
    *   - if return boolean is true, call 'isBatteryCorded' function
    *       - return the whatever string result from the function
    *   - if return boolean is false, call 'isMakeSlickingNoise' function
    *       - return the whatever string result from the function
    * create function 'isBatteryCorded' takes in nothing, return string
    *   - display prompt to user asking "Are the battery terminals corroded?: "
    *   - read string from user
    *   - call 'isYes' on user's input
    *   - if return boolean is true, return "Clean terminals and try starting again." to its caller
    *   - if return boolean is false, return "Replace cables and try again." to its caller
    * create function 'isMakeSlickingNoise' takes in nothing, return string
    *   - display prompt to user asking "Does the car make a slicking noise?: "
    *   - read string from user
    *   - call 'isYes' on user's input
    *   - if return boolean is true, return "Replace the battery." to its caller
    *   - if return boolean is false, call 'isCrankButNotStart'
    *       - return the whatever string result from the function
    * create function 'isCrankButNotStart' takes in nothing return a string
    *   - display prompt to user asking "Does the car crank up but fail to start?: "
    *   - read string from user
    *   - call 'isYes' on user's input
    *   - if return boolean is true, return "Check spark plug connections." to its caller
    *   - if return boolean is false, call 'isCarStartedButDie'
    *       - return the whatever string result from the function
    * create function 'isCarStartedButDie' takes in nothing, return a string
    *   - display prompt to user asking "Does the engine start and then die?: "
    *   - read string from user
    *   - call 'isYes' on user's input
    *   - if return boolean is true, call 'doesCarHaveFuelInjection'
    *       - return the whatever string result from the function
    *   - if return boolean is false, return "This should not be possible." to its caller
    * create function 'doesCarHaveFuelInjection' takes in nothing, return a string
    *   - display prompt to user asking "Does you car have fuel injection?: "
    *   - read string from user
    *   - call 'isYes' on user's input
    *   - if return boolean is true, return "Get it in for service." to its caller
    *   - if return boolean is false, return "Check to ensure the choke is opening and closing." to its caller
    *
    * Program starts here:
    *   - call the 'isNoiseWhenKeyIn' function
    *       - store the return value in 'output'
    *   - display the string in 'output' to user.
     */
    private static final Scanner input = new Scanner(System.in);

    private boolean isYes(String result){
        result = result.toLowerCase(Locale.ROOT);
        return (result.equals("yes") || result.equals("y"));
    }
    private String isNoiseWhenKeyIn(){
        System.out.print("Is the car silent when you turn the key?: ");
        if(isYes(input.nextLine()))
            return isBatteryCorded();
        else
            return isMakeSlickingNoise();
    }
    private String isBatteryCorded(){
        System.out.print("Are the battery terminals corroded?: ");
        if(isYes(input.nextLine()))
            return "Clean terminals and try starting again.";
        else
            return "Replace cables and try again.";
    }
    private String isMakeSlickingNoise(){
        System.out.print("Does the car make a slicking noise?: ");
        if(isYes(input.nextLine()))
            return "Replace the battery.";
        else
            return isCrankButNotStart();
    }
    private String isCrankButNotStart(){
        System.out.print("Does the car crank up but fail to start?: ");
        if(isYes(input.nextLine()))
            return "Check spark plug connection.";

        else
            return isCarStartedButDie();
    }
    private String isCarStartedButDie(){
        System.out.print("Does the engine start and then die?: ");
        if(isYes(input.nextLine()))
            return doesCarHaveFuelInjection();
        else
            return "This should not be possible.";
    }
    private String doesCarHaveFuelInjection(){
        System.out.print("Does you car have fuel injection?: ");
        if(isYes(input.nextLine()))
            return "Get it in for service.";
        else
            return "Check to ensure the choke is opening and closing.";
    }

    public static void main(String[] args) {
        Solution23 sol = new Solution23();

        System.out.println("Please enter either Yes(y), or No(n) whether this happens to your car..");

        String output = sol.isNoiseWhenKeyIn();

        System.out.println(output);
    }
}
