package com.demo;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        GetDuplication test1 = new GetDuplication();
//        test1.runTest();
//        FindInPartiallySortedMatrix test2 = new FindInPartiallySortedMatrix();
//        test2.runTest();
        QuickSort qs = new QuickSort();
        int[] arr = new int[]{6,1,9,2,8,3,7,4,7,5,6};
        qs.quickSort(arr);
        qs.quickSortDe(arr);

    }
}
