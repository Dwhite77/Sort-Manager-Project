package com.sparta.model;

public class MergeSort extends SuperSort {
    //--------------------------------------------------------------------------
    // this is the method where the mergeSort is done
    //--------------------------------------------------------------------------
    @Override
    public int[] sort(int[] array)
    {
        if(array.length > 1) // if the array has more than one item in it then we split it and merge the sorted halves
        {
            int elementsInLeft = array.length / 2;
            int elementsInRight = array.length - elementsInLeft;
            int leftArr[] = new int[elementsInLeft];
            int rightArr[] = new int[elementsInRight];

            for(int i = 0; i < elementsInLeft; i++)
                leftArr[i] = array[i];

            for(int i = elementsInLeft; i < elementsInLeft + elementsInRight; i++)
                rightArr[i - elementsInLeft] = array[i];

            leftArr = sort(leftArr);
            rightArr = sort(rightArr);

            int i = 0, j = 0, k = 0;

            while(leftArr.length != j && rightArr.length != k)
            {
                if(leftArr[j] < rightArr[k])
                {
                    array[i] = leftArr[j];
                    i++;
                    j++;
                }

                else
                {
                    array[i] = rightArr[k];
                    i++;
                    k++;
                }
            }

            while(leftArr.length != j)
            {
                array[i] = leftArr[j];
                i++;
                j++;
            }
            while(rightArr.length != k)
            {
                array[i] = rightArr[k];
                i++;
                k++;
            }
        }
        return array;
    }

    @Override
    public String toString() {
        return "MergeSort";
    }
}


