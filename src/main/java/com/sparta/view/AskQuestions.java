package com.sparta.view;

import com.sparta.model.SortManager;

import java.util.Scanner;

//----------------------------------------------------------------------------------------------
//  This is the Class that asks the questions to the user
//----------------------------------------------------------------------------------------------


public class AskQuestions {
    public static void askQuestions(){
        System.out.println("What type of sort would you like to use? BubbleSort, QuickSort or MergeSort");
        Scanner scn = new Scanner(System.in);
        String choice = scn.next();
        System.out.println("What size array would you like to use?");
        int choice2 = scn.nextInt();

        SortManager newManager = new SortManager();
        newManager.sortManager(choice2, choice);

        System.out.println("Do you want to do another sort?");
        String again = scn.next();
        if(again.equals("yes")){
            askQuestions();
        }
        else System.exit(0);

    }
}
