package com.sparta.model;

import static java.lang.System.nanoTime;

public class SortManager {

    //----------------------------------------------------------------------------------------------
    //  This is the method where the logic starts from
    //----------------------------------------------------------------------------------------------


    public static void sortManager(int arraySize, String choice){ // change the name of this method
        long start, end;
        SortFactory theFactory;
        IntArrayGenerate intArray = new IntArrayGenerate();
        int[] myArr = intArray.intArrayGen(arraySize);
        start = nanoTime();
        switch (choice){
            case "BubbleSort","bubblesort","B","b","Bubble","bubble": theFactory = new BubbleSort(); break;
            case "MergeSort","mergesort","merge","Merge","M","m": theFactory = new MergeSort(); break;
            case "QuickSort","quicksort","q","Q","quick","Quick" : theFactory = new QuickSort(); break;
            default: theFactory = new MergeSort(); break;
        }
        //int[] mySortedArray = theFactory.sort(myArr);
        //theFactory.printArray(mySortedArray);
        theFactory.printArray(theFactory.sort(myArr));
        end = nanoTime();
        System.out.println("Type of sort used: "+ theFactory.toString());
        System.out.println("Elapsed Time: "+ (end - start));
    }

}
