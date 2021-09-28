package com.sparta.model;

public abstract class SuperSort implements SortFactory{

    abstract public int[] sort(int[] arrInp);

    public void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}
