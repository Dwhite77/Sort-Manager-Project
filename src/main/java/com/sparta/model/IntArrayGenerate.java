package com.sparta.model;

import java.util.Random;

//----------------------------------------------------------------------------------------------
//  This is the method generates an array of random numbers of an input length
//----------------------------------------------------------------------------------------------
public class IntArrayGenerate {

    public static int[] intArrayGen(int arrayLength){
        int[] myArr = new int[arrayLength];
        Random r = new Random();
        for(int i = 0; i < arrayLength; i++){
            myArr[i] = r.nextInt(100);
        }
        return myArr;
    }

}
