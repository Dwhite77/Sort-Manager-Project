package com.sparta.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class TestBinaryTreeSort {
    @Test
    public void givenArrayReturnSortedArray(){
        int[] testArray = {12,23,54,1,20,10};
        int[] testSortedArray = {1,10,12,20,23,54};
        BinaryTreeSort theTreeTest = new BinaryTreeSort();
        int[] sortedArray = theTreeTest.sort(testArray);
        assertArrayEquals(testSortedArray, sortedArray);
    }
    @Test
    public void givenArrayWithTwoEqualIntsReturnSortedArray(){
        int[] testArray = {12,12,54,1,20,10};
        int[] testSortedArray = {1,10,12,12,20,54};
        BinaryTreeSort theTreeTest = new BinaryTreeSort();
        int[] sortedArray = theTreeTest.sort(testArray);
        assertArrayEquals(testSortedArray, sortedArray);
    }

    @Test
    public void givenArrayWithThreeEqualIntsReturnSortedArray(){
        int[] testArray = {12,12,54,1,20,12};
        int[] testSortedArray = {1,12,12,12,20,54};
        BinaryTreeSort theTreeTest = new BinaryTreeSort();
        int[] sortedArray = theTreeTest.sort(testArray);
        assertArrayEquals(testSortedArray, sortedArray);
    }

    @Test
    public void givenArrayWithMultipleEqualIntsReturnSortedArray(){
        int[] testArray = {20,12,54,1,20,12};
        int[] testSortedArray = {1,12,12,20,20,54};
        BinaryTreeSort theTreeTest = new BinaryTreeSort();
        int[] sortedArray = theTreeTest.sort(testArray);
        assertArrayEquals(testSortedArray, sortedArray);
    }

    @Test
    public void givenArrayWithOnlyEqualIntsReturnSortedArray(){
        int[] testArray = {20,20,20,12,12,12};
        int[] testSortedArray = {12,12,12,20,20,20};
        BinaryTreeSort theTreeTest = new BinaryTreeSort();
        int[] sortedArray = theTreeTest.sort(testArray);
        assertArrayEquals(testSortedArray, sortedArray);
    }
    @Test
    public void givenArrayWithOnlyEqualIntsReturnSortedArray2(){
        int[] testArray = {20,12,20,12,20,12};
        int[] testSortedArray = {12,12,12,20,20,20};
        BinaryTreeSort theTreeTest = new BinaryTreeSort();
        int[] sortedArray = theTreeTest.sort(testArray);
        assertArrayEquals(testSortedArray, sortedArray);
    }
}
