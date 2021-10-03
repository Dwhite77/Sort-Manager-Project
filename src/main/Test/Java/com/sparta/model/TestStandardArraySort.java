package com.sparta.model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class TestStandardArraySort {
    @Test
    public void givenArrayReturnSortedArray(){
        int[] inputArray = {12,23,54,34,45,90,1};
        int[] sortedArray = {1,12,23,34,45,54,90};
        StandardArraySort sASort = new StandardArraySort();
        sASort.sort(inputArray);
        assertArrayEquals(sortedArray,inputArray);
    }
}
