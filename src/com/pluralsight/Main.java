package com.pluralsight;

import java.util.Scanner;

public class Main {

    /*
    https://programmingbydoing.com/

    Nim - Assignment 63c (Original assignment + Bonus #1 and #2)
     */

    public static void main(String[] args) {
	// write your code here

        Scanner keyboard = new Scanner(System.in);

        int countA = 3;
        int countB = 4;
        int countC = 5;
        int total = countA + countB + countC;
        System.out.println("Player 1, enter your name:");
        String player1 = keyboard.next();
        System.out.println("Player 2, enter your name:");
        String player2 = keyboard.next();
        String currentPlayer = player1;
        String otherPlayer = player2;

//Play game until no counters left
        while (total > 1){
            System.out.println("A:" + countA + "    B:" + countB + "    C:" + countC);
            System.out.println();
            System.out.println(currentPlayer + ", choose a pile:");
            String pile = keyboard.next();
            boolean valid = false;

//Determine if the chosen pile is valid (isn't a counter of 0 and can be reduced)
            while (valid == false){
                if (pile.equalsIgnoreCase("A") && countA > 0){
                    valid = true;
                }
                else if (pile.equalsIgnoreCase("B") && countB > 0){
                    valid = true;
                }
                else if (pile.equalsIgnoreCase("C") && countC > 0) {
                    valid = true;
                }
                else
                    valid = false;

                if (valid == false){
                    System.out.println("Nice try, " + currentPlayer + " That pile is empty. Choose again:");
                    pile = keyboard.next();
                }
            }

            System.out.println("How many to remove from pile " + pile + " ?");
            int reduce = keyboard.nextInt();

//Determine if the reduction value is valid (isn't greater than the counter)
            valid = false;
            while (valid == false){
                if (pile.equalsIgnoreCase("A") && (countA-reduce >= 0)){
                    valid = true;
                }
                else if (pile.equalsIgnoreCase("B") && (countB-reduce >= 0)){
                    valid = true;
                }
                else if (pile.equalsIgnoreCase("C") && (countC-reduce >= 0)) {
                    valid = true;
                }
                else
                    valid = false;

                if (valid == false){
                    System.out.println("Pile " + pile + " doesn't have that many. Try again:");
                    reduce = keyboard.nextInt();
                }
            }
//Determine if the reduction value is valid (isn't negative)
            while (reduce <= 0){
                    System.out.println("You must choose at least 1. Try again:");
                    reduce = keyboard.nextInt();
                }

//Determine pile to be reduced and proceed
            if (pile.equalsIgnoreCase("A")){
                countA -= reduce;
            }
            else if (pile.equalsIgnoreCase("B")){
                countB -= reduce;
            }
            else
                countC -= reduce;

//Reset total
            total = countA + countB + countC;

//Switch to next player
            if (currentPlayer == player1){
                currentPlayer =  player2;
                otherPlayer = player1;
            }
            else {
                currentPlayer = player1;
                otherPlayer = player2;
            }

//Determine if there is only 1 counter remaining and declare the winner one step early
            if (total == 1){
                System.out.println(currentPlayer + ", you must take the last remaining counter, so you lose. " +
                otherPlayer + " wins!");
            }
        }

//End the game and declare the winner
        if (total == 0){
            System.out.println(currentPlayer + ", there are no counters left, so you win");
        }


    }
}
