package com.sparta.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


// all of the sort types are difficult to test as i need to create int arrys to test them


public class TestMergeSort {
    @Test
    public void testSort(){
        MergeSort myMergeSort = new MergeSort();
        IntArrayGenerate myArray = new IntArrayGenerate();

        int[] sortedArr = myMergeSort.sort(myArray.intArrayGen(20));
        int count = 0;
        for(int i = 0; i < sortedArr.length-1; i++) {
            if (sortedArr[i] <= sortedArr[i + 1]) {
                count++;
            }
        }
        assertEquals(count,sortedArr.length-1);
    }
}
