package com.sparta.viewandcontroller;

import com.sparta.logging.LoggingMain;
import com.sparta.model.*;
import org.apache.log4j.Logger;

import static java.lang.System.getLogger;
import static java.lang.System.nanoTime;

public class SortManager {

    //----------------------------------------------------------------------------------------------
    //  This is the method where the logic starts from
    //----------------------------------------------------------------------------------------------


    public static void sortManager(int arraySize, String choice){ // change the name of this method
        long start, end;
        SortFactory theFactory;
        IntArrayGenerate intArray = new IntArrayGenerate();

        try{
            int[] exceptionArr = new int[arraySize];
        }catch(NegativeArraySizeException e){
            System.err.println("Negative Array size selected please try to use a positive integer");
            Logger log = LoggingMain.getLogger();
            log.error("User didn't Select a positive integer for the Array size");
            AskQuestions.askQuestions();
        }
        //  I want to go through this and make it so that the integer input is checked, ill have to do a test of a negative int or something
        finally {
            int[] myArr = intArray.intArrayGen(arraySize);
            start = nanoTime();

            // if im going to use a gui do I need to add try catch exceptions here?
            // my gui will hav an input for the size of array so I will catch that and can use what I have here to replace it with
            // array of sorters that is populated from the gui selections when the go button is pressed
            switch (choice) {
                case "BubbleSort", "bubblesort", "Bubble", "bubble":
                    theFactory = new BubbleSort();
                    break;
                case "MergeSort", "mergesort", "merge", "Merge", "M", "m":
                    theFactory = new MergeSort();
                    break;
                case "QuickSort", "quicksort", "q", "Q", "quick", "Quick":
                    theFactory = new QuickSort();
                    break;
                case "Binary", "binary", "bin", "Bin", "BinarySort", "BinaryTree", "BinaryTreeSort" , "binarytreesort", "binarysort", "binarytree":
                    theFactory = new BinaryTreeSort();
                    break;
                case "selection","Selection","s","S":
                    theFactory = new SelectionSort();
                    break;
                case "Insertion","insertion","i","I":
                    theFactory = new InsertionSort();
                    break;
                default:
                    theFactory = null;
                    break;
            }

            //int[] mySortedArray = theFactory.sort(myArr);
            //theFactory.printArray(mySortedArray);
            try {
                theFactory.printArray(theFactory.sort(myArr));
            } catch (Exception e) {
//                e.printStackTrace();
                System.err.println("Choose an actual Sort!");
                Logger log = LoggingMain.getLogger();
                log.error("User didn't Select an actual sort");
                AskQuestions.askQuestions();
            }finally {

            end = nanoTime();
            System.out.println("Type of sort used: " + theFactory.toString());
            System.out.println("Elapsed Time: " + (end - start));

            }
        }
    }

}
