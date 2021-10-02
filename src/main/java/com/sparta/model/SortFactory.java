package com.sparta.model;

public interface SortFactory {
    int[] sort(int[] arrInp);
    void printArray(int[] arrInp);
    long getCompletionTime();
    void setStartTime();
    void setEndTime();

    String arrayString(int[] tempArr);

    // every single one of the sort types implements all of these - SOLID Interface Segregation Principle - thin interface that everything implementing it uses everything in it
}
