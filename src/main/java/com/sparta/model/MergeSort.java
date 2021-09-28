package com.sparta.model;

public class MergeSort extends SuperSort {

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


}


//    public void sort(int arr[], int len, int r)
//    {
//        if (len < r) {
//
//            int middle = len + (r-len)/2;         // Find the middle point
//
//            sort(arr, len, middle);             // Sort first and second halves
//            sort(arr, middle + 1, r);
//
//            merge(arr, len, middle, r);         // Merge the sorted halves
//        }
//    }
//
//    public void merge(int arr[], int len, int middle, int r)
//    {
//        // Find sizes of two subarrays to be merged
//        int n1 = middle - len + 1;
//        int n2 = r - middle;
//
//        /* Create temp arrays */
//        int L[] = new int[n1];
//        int R[] = new int[n2];
//
//        /*Copy data to temp arrays*/
//        for (int i = 0; i < n1; ++i)
//            L[i] = arr[len + i];
//        for (int j = 0; j < n2; ++j)
//            R[j] = arr[middle + 1 + j];
//
//        /* Merge the temp arrays */
//
//        // Initial indexes of first and second subarrays
//        int i = 0, j = 0;
//
//        // Initial index of merged subarray array
//        int k = len;
//        while (i < n1 && j < n2) {
//            if (L[i] <= R[j]) {
//                arr[k] = L[i];
//                i++;
//            }
//            else {
//                arr[k] = R[j];
//                j++;
//            }
//            k++;
//        }
//
//        /* Copy remaining elements of L[] if any */
//        while (i < n1) {
//            arr[k] = L[i];
//            i++;
//            k++;
//        }
//
//        /* Copy remaining elements of R[] if any */
//        while (j < n2) {
//            arr[k] = R[j];
//            j++;
//            k++;
//        }
//    }
//

    