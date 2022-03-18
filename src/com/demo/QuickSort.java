package com.demo;

import java.util.Arrays;

public class QuickSort {
    public int[] quickSort(int[] arr) {
        int[] sortedarr = Arrays.copyOf(arr, arr.length);

        qsort(sortedarr, 0, sortedarr.length-1);
        for(int a : sortedarr) {
            System.out.print(a + ",");
        }

        return sortedarr;
    }

    // 倒序排序
    public int[] quickSortDe(int[] arr) {
        int[] sortedarr = Arrays.copyOf(arr, arr.length);

        qsortDe(sortedarr, 0, sortedarr.length-1);
        for(int a : sortedarr) {
            System.out.print(a + ",");
        }

        return sortedarr;
    }

    private int[] qsortDe(int[] arr, int left, int right) {
        if(left<right) {
            int partitionIndex = qpartitionDe(arr, left, right);
            qsortDe(arr, left, partitionIndex - 1);
            qsortDe(arr, partitionIndex+1, right);
        }

        return arr;

    }
    private int qpartitionDe(int[] arr, int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        for(int i = index; i<=right; i++){
            if(arr[i]>arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index-1);
        return index-1;
    }

    private int[] qsort(int[] arr, int left, int right) {
        if(left<right) {
            int partitionIndex = qpartition(arr, left, right);
            qsort(arr, left, partitionIndex - 1);
            qsort(arr, partitionIndex+1, right);
        }

        return arr;

    }

    private int qpartition(int[] arr, int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        // index 的意义是, 指向 距离pivot最近的比pivot大的数, index在swap后会增加, 但总是去寻找距离pivot最近的比pivot大的数
        // 若比pivot小则index++直到找到比pivot大的, 此时index便一直指向这个数, 直到i找到比pivot小的数, 此时交换i和index, index继续寻找下一个距离pivot最近的比pivot大的数

        for(int i = index; i<=right; i++){
            if(arr[i]<arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }

        // index-1 的位置是不比pivot大的数, 交换 pivot 和 index-1 使得交换后的 pivot 位置(即交换前的index-1位置)左边的数均不大于当前的pivot
        // 注意, 交换的只是两个位置上的数
        swap(arr, pivot, index-1);
        return index-1;
    }

    void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
