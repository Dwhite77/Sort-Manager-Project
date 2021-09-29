package com.sparta.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestQuickSort {
    @Test
    public void testSort(){
        QuickSort myQuickSort = new QuickSort();
        IntArrayGenerate myArray = new IntArrayGenerate();

        int[] sortedArr = myQuickSort.sort(myArray.intArrayGen(20));
        int count = 0;
        for(int i = 0; i < sortedArr.length-1; i++) {
            if (sortedArr[i] <= sortedArr[i + 1]) {
                count++;
            }
        }
        assertTrue(count == sortedArr.length-1);
    }
}
