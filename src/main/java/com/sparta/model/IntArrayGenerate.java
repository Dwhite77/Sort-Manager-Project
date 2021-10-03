package com.sparta.model;

import java.util.Random;

//----------------------------------------------------------------------------------------------
//  This is the method generates an array of random numbers of an input length - default upper bounds is 100
//----------------------------------------------------------------------------------------------
public class IntArrayGenerate {

    public static int[] intArrayGen(int arrayLength){
        int[] myArr = new int[arrayLength];
        Random r = new Random();

        for(int i = 0; i < arrayLength; i++){
            myArr[i] = r.nextInt(100); // if you want to change the upper limit of the sorted numbers change this
        }
        return myArr;
    }

}
