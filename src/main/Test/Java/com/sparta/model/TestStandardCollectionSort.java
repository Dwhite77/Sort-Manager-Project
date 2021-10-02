package com.sparta.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestStandardCollectionSort {

    @Test
    public void givenArrInputReturnSortedArray(){
        int[] testArray = {12,45,23,78,1,90};
        int[] sortedArray = {1,12,23,45,78,90};
        StandardCollectionSort colSort = new StandardCollectionSort();
        int[] outputArray = colSort.sort(testArray);
        assertArrayEquals(sortedArray,outputArray);

    }


}
