package com.sparta.model;
import static java.lang.System.nanoTime;

public abstract class SuperSort implements SortFactory{

    abstract public int[] sort(int[] arrInp);

    private long startTime;
    private long endTime;

    public long getCompletionTime(){
        return (endTime - startTime);

    }

    public void setStartTime(){
        startTime = nanoTime();
    }
    public void setEndTime(){
        endTime = nanoTime();
    }

    public void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}
