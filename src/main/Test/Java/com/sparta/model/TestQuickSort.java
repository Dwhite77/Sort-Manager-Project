package com.sparta.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestQuickSort {


    @Test
    public void givenRandomArrayReturnSortedArray(){
        IntArrayGenerate myArray = new IntArrayGenerate();
        QuickSort myQuickSort = new QuickSort();
        int[] sortedArr = myQuickSort.sort(myArray.intArrayGen(20));
        int count = 0;
        for(int i = 0; i < sortedArr.length-1; i++) {
            if (sortedArr[i] <= sortedArr[i + 1]) {
                count++;
            }
        }
        assertEquals(count,sortedArr.length-1);
    }

    @Test
    public void givenTwoNumbersInAnArrayReturnSwappedNumbersInAnArray(){
        int[] myArr = {12,23};
        int[] mySwappedArr = {23,12};
        QuickSort.swap(myArr,0,1);
        assertArrayEquals(myArr,mySwappedArr);
    }

    @Test
    public void givenArrayAndHighAndLowDoesThisReturnTheNumberOfValuesSmallerThanTheLastValue(){
        int[] myArr = {12,23,45,56,11,9,10,15,18};
        int pi = QuickSort.partition(myArr,0,myArr.length-1);
        assertEquals(5,pi);
    }

    @Test
    public void givenArrayAndHighAndLowDoesThisReturnTheNumberOfValuesSmallerThanTheLastValueWithEvenArraySize(){
        int[] myArr = {12,23,45,56,11,9,10,15,18,10};
        int pi = QuickSort.partition(myArr,0,myArr.length-1);
        assertEquals(1,pi);
    }
}
