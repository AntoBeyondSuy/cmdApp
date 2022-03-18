package com.leetcode;

import com.demo.FindNumToSort;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        LongestSubstring longestSubstring = new LongestSubstring();
//        longestSubstring.test();
//        ZigZagConvert zzc = new ZigZagConvert();
//        zzc.test();
//        ReverseInteger ri = new ReverseInteger();
//        ri.test(123, 321);
//        FindNumToSort fnts = new FindNumToSort();
//        fnts.test();
//        LongestCommonPrefix lcp = new LongestCommonPrefix();
//        lcp.test();
//        CheckInclusion ci = new CheckInclusion();
//        ci.test();
//        StringMultiply sm = new StringMultiply();
//        sm.test();
//        ReverseWordsInSen rwis = new ReverseWordsInSen();
//        rwis.test();
//        SimplifyPath sp = new SimplifyPath();
//        sp.test();
//        RestoreIpAddr ria = new RestoreIpAddr();
//        ria.test();
//        ThreeSumZero tsz = new ThreeSumZero();
//        tsz.test();
//        MaxAreaOfIsland mai = new MaxAreaOfIsland();
//        mai.test();
//        SearchRotateArray sra = new SearchRotateArray();
//        sra.test();
//        TrapRain tr = new TrapRain();
//        tr.test();
//        MaxProfit mp = new MaxProfit();
//        mp.test();
//        MaxSubArray msa = new MaxSubArray();
//        msa.test();
//        DishesBetweenCandles2055 dbc = new DishesBetweenCandles2055();
//        dbc.test();
//        PreorderNtree pnt = new PreorderNtree();
//        pnt.test();
//        Utf8Certify vu8 = new Utf8Certify();
//        vu8.test();
//        FindLeastSameIndexes599 flsi = new FindLeastSameIndexes599();
//        flsi.test();
//        MaximalSquare ms = new MaximalSquare();
//        ms.test();
//        FindKthLargest fkl = new FindKthLargest();
//        fkl.test();
//        LongestConsecutive lc = new LongestConsecutive();
//        lc.test();
        GetPermutation gp = new GetPermutation();
//        System.out.println(gp.getPermutation(4, 9) + " =? 2314");
        System.out.println(gp.getPermutation(3, 2) + " =? 132");
//        System.out.println(gp.getPermutation(3, 1) + " =? 123");
//        System.out.println(gp.getPermutation(6, 435) + " =? 451326");


    }

    /**
     * 快慢指针: 存在环
     * 归并排序等 二分法: nlogn
     * 哈希表
     * 有重合的位置, 则找重合位置的规律(如长度)
     */

    int[] quickSort(int[] oriArr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(oriArr, left, right);
            quickSort(oriArr, left, partitionIndex - 1);
            quickSort(oriArr, partitionIndex + 1, right);
        }
        return oriArr;

    }

    int partition(int[] arr, int left, int right) {
        int pivot = left;
        int biggerIndex = pivot + 1;
        for (int i = biggerIndex; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, biggerIndex);
                biggerIndex++;
            }
        }
        swap(arr, pivot, biggerIndex - 1);
        return biggerIndex - 1;

    }


    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

    }

    void iteratorHashSet(HashSet<Integer> set) {
        for (Integer integer : set) {
            System.out.println(integer.intValue());
        }

    }

    void iteratorHashMap(HashMap<Integer, String> map) {

        for (Integer integer : map.keySet()) {
            System.out.println(map.get(integer));
        }

    }


}
