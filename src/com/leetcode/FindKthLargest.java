package com.leetcode;

import java.util.Arrays;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int[] arrcopy = Arrays.copyOf(nums, nums.length);
        return qsortK(arrcopy, 0, nums.length-1, k);

    }

    int qsortK(int[] nums, int left, int right, int k) {

        int partition = qpartition(nums, left, right);
        if((k-1)==partition) return nums[partition];
        if((k-1)>partition) return qsortK(nums, partition + 1, right, k);
        // k<partition
        return qsortK(nums, left, partition - 1, k);

    }


    int qpartition(int[] nums, int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        for(int i = index; i<=right; i++) {
            if(nums[i]>nums[pivot]) {
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, pivot, index-1);
        return index-1;
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    void test() {
        int[] nums1 = new int[]{3,2,1,5,6,4};
        int k1 = 2, a1 = 5;
        int[] nums2 = new int[]{3,2,3,1,2,4,5,5,6};
        int k2 = 4, a2 = 4;
        int[] nums3 = new int[]{1,9,9,9,9,9,9,9,1};
        int k3 = 8, a3 = 1;
        int[] nums4 = new int[]{8,8,8,8,8,8,8,8,8,8,8,8};
        int k4 = 12, a4 = 8;

        System.out.println(findKthLargest(nums1, k1) + " =? " + a1);
        System.out.println(findKthLargest(nums2, k2) + " =? " + a2);
        System.out.println(findKthLargest(nums3, k3) + " =? " + a3);
        System.out.println(findKthLargest(nums4, k4) + " =? " + a4);
    }


}

