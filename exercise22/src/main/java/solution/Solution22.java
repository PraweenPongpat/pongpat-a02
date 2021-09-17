/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution for exercise22
 *  Copyright 2021 Praween Pongpat
 */

package solution;

import java.util.Scanner;

public class Solution22 {
    /*
    * create a function 'getDouble' that takes in an integer to prompt the order of that number, returns double
    *   - display the prompt in the context "Enter the xx number: " where xx is the 'prompt' passed in
    *   - read double from user
    *   - return the double to its caller
    * create a function 'findMax' that determines the maximum number, takes in an array of double, returns double
    *   - set the loop to iterate three times, since we asked for three numbers
    *   - 'temp' will be initialized to the first element of the array
    *   - compare 'temp' to the next element in the array:
    *       - if 'temp' is less than next element,  update 'temp' to that element in the array
    *       - if 'temp' is equal/more than the next element, do nothing.
    *   - after all iteration, we will have maximum double stored in 'temp'
    *   - return 'temp' to its caller
    *
    * program starts here:
    *   create array of double of size 3, since this exercise explicitly said for only three numbers
    *   create a loop that will iterate three times
    *       - each iteration, call 'getDouble' passing in the order of that number (i.e. 1,2,3)
    *           - store that number in the array
    *       - as long as it is NOT the first element, check if the current number equals to previous number
    *           - if so: 'flag' += 1
    *   after loop, if 'flag' is only 1 less than total number of element, means all numbers are the same
    *       - return; to exit the program
    *   Reaching this point means all numbers are not the same.
    *   call 'findMax' function: store the return value in 'max'
    *   display output
    *       - "The largest number is xx' where xx is 'max' that we found
     */
    private static final Scanner input = new Scanner(System.in);

    private double getDouble(int i){
        while(true){
            System.out.print("Please enter number#" + i + ": ");
            try{
                return Double.parseDouble(input.nextLine());
            } catch (NumberFormatException nfe){
                System.out.println("Please enter a number... NUMBER!");
            }
        }
    }
    private double findMax(double[] array){
        double tempMax = array[0];
        for (double v : array) {
            if (tempMax < v) {
                tempMax = v;
            }
        }
        return tempMax;
    }

    public static void main(String[] args) {
        Solution22 sol = new Solution22();

        double[] numArray = {0.00,0.00,0.00};
        int flag=0;
        for(int i = 0; i < numArray.length; i++){
            numArray[i] = sol.getDouble(i+1);
            if(i>0 && numArray[i-1]==numArray[i]){
                flag++;
            }
        }
        if(flag == (numArray.length-1)){
            return;
        }

        double max = sol.findMax(numArray);

        System.out.printf("The max number of all is: %.2f%n", max);
    }
}
