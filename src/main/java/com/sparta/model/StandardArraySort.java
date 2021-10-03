package com.sparta.model;
import java.util.Arrays;

public class StandardArraySort extends SuperSort{
    @Override
    public int[] sort(int[] arrInp) {
        setStartTime();
        Arrays.sort(arrInp);
        setEndTime();
        return arrInp;
    }

    @Override
    public String toString() {
        return "StandardArraySort";
    }
}
