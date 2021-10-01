package com.sparta.model;

public interface SortFactory {
    int[] sort(int[] arrInp);
    void printArray(int[] arrInp);

    long getCompletionTime();
    void setStartTime();
    void setEndTime();
}
