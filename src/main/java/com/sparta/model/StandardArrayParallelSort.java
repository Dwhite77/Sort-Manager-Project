package com.sparta.model;
import java.util.Arrays;

public class StandardArrayParallelSort extends SuperSort{
    @Override
    public int[] sort(int[] arrInp) {
        setStartTime();
        Arrays.parallelSort(arrInp);
        setEndTime();
        return arrInp;
    }

    @Override
    public String toString() {
        return "StandardArrayParallelSort";
    }
}
