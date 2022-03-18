package com.leetcode;

public class SearchRotateArray {
    /*
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > nums[end]){
                if(nums[mid] > target && nums[start] <= target){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else{
                if(nums[mid] < target && target <= nums[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
     */
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return (nums[0] == target) ? 0 : -1;
        }
        int first = 0, last = nums.length - 1;
        if (nums[first] < nums[last]) {  // 说明没有旋转
            return binarySearch(nums, target);
        } else {
            while (first < last && nums[first] > nums[last]) {
                if (nums[first] == target) return first;
                if (nums[last] == target) return last;
                if (nums[first] > target && nums[last] < target) return -1;
                if (nums[first] < target) {
                    first++;
                } else if (nums[last] > target) {
                    last--;
                }
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {//向左查找
                right = mid - 1;
            } else {//向右查找
                left = mid + 1;
            }
        }
        return -1;
    }


    void test() {
//        int[] n1 = new int[]{0};
//        int[] n2 = new int[]{9, 0, 1, 2, 3, 4, 6, 7, 8};
//        int[] n3 = new int[]{6, 7, 8, 9, 0, 1, 2, 3, 4};
//        int[] n4 = new int[]{1, 2, 3, 4, -4, -3, -2, -1};
//        int[] n5 = new int[]{3, 1};
        int[] n6 = new int[]{1,3};
        int[] n7 = new int[]{1,3,4,7,8,9,10};

//        System.out.println(search(n1, 6) + " == -1");
//        System.out.println(search(n2, 6) + " == 6");
//        System.out.println(search(n3, 4) + " == 8");
//        System.out.println(search(n4, -4) + " == 4");
//        System.out.println(search(n5, 3) + " == 0");
//        System.out.println(search(n5, 1) + " == 1");
        System.out.println(search(n6, 1) + " == 0");
        System.out.println(search(n7, 10) + " == 6");
        System.out.println(search(n7, 5) + " == -1");
    }
}
