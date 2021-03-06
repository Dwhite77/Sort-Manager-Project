package com.sparta.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestInsertionSort {
    @Test
    public void givenRandomArrayDoesSelectionSortCorrectly(){
        InsertionSort myInsertionSort = new InsertionSort();
        IntArrayGenerate myArray = new IntArrayGenerate();

        int[] sortedArr = myInsertionSort.sort(myArray.intArrayGen(20));
        int count = 0;
        for(int i = 0; i < sortedArr.length-1; i++) {
            if (sortedArr[i] <= sortedArr[i + 1]) {
                count++;
            }
        }
        assertEquals(count,sortedArr.length-1);
    }
}
