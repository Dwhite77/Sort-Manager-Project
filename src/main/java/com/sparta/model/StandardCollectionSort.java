package com.sparta.model;


import java.util.ArrayList;
import java.util.Collections;

public class StandardCollectionSort extends SuperSort{

    @Override
    public int[] sort(int[] arrInp) {
        int[] outArr = new int[arrInp.length];

        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        for(int i =0; i< arrInp.length;i++){
            arrayList.add(arrInp[i]);
        }
        setStartTime();

        Collections.sort(arrayList);

        setEndTime();

        Integer[] tempArr =  arrayList.toArray(new Integer[arrInp.length]);

        for(int i =0; i<tempArr.length;i++) {
            outArr[i] = tempArr[i].intValue();
        }
        return outArr;
    }

    @Override
    public String toString() {
        return "StandardCollectionSort";
    }
}
