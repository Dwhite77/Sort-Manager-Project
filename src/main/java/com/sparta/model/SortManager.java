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
            case "BubbleSort": theFactory = new BubbleSort(); break;
            case "MergeSort": theFactory = new MergeSort(); break;
            case "QuickSort" : theFactory = new QuickSort(); break;
            default: theFactory = new MergeSort(); break;
        }

        int[] mySortedArray = theFactory.sort(myArr);
        theFactory.printArray(mySortedArray);
        end = nanoTime();
        System.out.println("Elapsed Time: "+ (end - start));
    }

}
