package com.sparta.model;

public class BubbleSort extends SuperSort {
    //--------------------------------------------------------------------------
    // this is the method where the bubbleSort is done
    //--------------------------------------------------------------------------
    @Override
    public int[] sort(int[] arrInp) {
        setStartTime();
        int n = arrInp.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arrInp[j] > arrInp[j + 1]) {
                    int temp = arrInp[j];
                    arrInp[j] = arrInp[j + 1];
                    arrInp[j + 1] = temp;
                }
            }
        }
        setEndTime();
        return arrInp;
    }

    @Override
    public String toString() {
        return "BubbleSort";
    }
}
