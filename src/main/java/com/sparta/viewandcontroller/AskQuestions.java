package com.sparta.viewandcontroller;

import java.util.InputMismatchException;
import java.util.Scanner;

//----------------------------------------------------------------------------------------------
//  This is the Class that asks the questions to the user
//----------------------------------------------------------------------------------------------


public class AskQuestions {
    public static void askQuestions(){
        int choice2 =0;
        System.out.println("What type of sort would you like to use? BubbleSort, QuickSort, BinaryTreeSort, InsertionSort, SelectionSort or MergeSort");
        Scanner scn = new Scanner(System.in);
        String choice = scn.next(); //<----------------------------------------------this is currently the input for type of sort wanted
        System.out.println("What size array would you like to use?");
        try{
            choice2 = scn.nextInt(); //<------------------------------------------------- this is currently where the input of array size is
        } catch (InputMismatchException e){
            System.err.println("Input Error try again");
            askQuestions();
        }finally{

            SortManager newManager = new SortManager();
            newManager.sortManager(choice2, choice);

            System.out.println("Do you want to do another sort?");
            String again = scn.next();

            if(again.equals("yes") || again.equals("y") || again.equals("Y") || again.equals("Yes")){ //<-----------------this is what again needs to do (although we arent using askquestions so maybe it isnt necessary, instead maybe it reloads the gui and deletes the old one.
                askQuestions();
            }
            else System.exit(0);
        }

    }


}
