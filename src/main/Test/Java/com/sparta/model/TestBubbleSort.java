package com.sparta.model;

import com.sparta.logging.LoggingMain;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBubbleSort {
    @Test
    public void givenRandomArrayDoesSelectionSortCorrectly(){
        BubbleSort myBubbleSort = new BubbleSort();
        IntArrayGenerate myArray = new IntArrayGenerate();

        int[] sortedArr = myBubbleSort.sort(myArray.intArrayGen(20));
        int count = 0;
        for(int i = 0; i < sortedArr.length-1; i++) {
            if (sortedArr[i] <= sortedArr[i + 1]) {
                count++;
            }
        }
        assertEquals(count,sortedArr.length-1);
        LoggingMain log = new LoggingMain();
    }
}
