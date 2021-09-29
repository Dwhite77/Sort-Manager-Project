package com.sparta.model;


public class QuickSort extends SuperSort{
    //--------------------------------------------------------------------------
    // this is the sort function that triggers quicksort by arranging
    //--------------------------------------------------------------------------
    @Override
    public int[] sort(int[] arr){
        int low = 0;
        int high = arr.length-1;
        quickSort(arr,low,high);
        return arr;
    }

    //--------------------------------------------------------------------------
    // this is the method where the sorting is actually done
    //--------------------------------------------------------------------------

    static int[] quickSort(int[] arr, int low, int high)
    {
        if (low < high)
        {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
        return arr;
    }

    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int low, int high)
    {
        int pivot = arr[high];
        int i = (low - 1);
        for(int j = low; j <= high - 1; j++)
        {
            if (arr[j] < pivot)
            {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }


}
