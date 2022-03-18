package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int num : nums) {
            if(map.containsKey(num)) continue;
            int leftl = map.getOrDefault(num-1, 0);
            int rightl = map.getOrDefault(num+1, 0);
            int longerLength = leftl + rightl + 1;
            ans = Math.max(ans, longerLength);

            map.put(num, longerLength);
            map.put(num-leftl, longerLength);
            map.put(num+rightl, longerLength);
        }

        return ans;
    }


    public void test() {
        int[] nums1 = {100,4,200,1,3,2};
        int a1 = 4;
        int[] nums2 = {0,3,7,2,5,8,4,6,0,1};
        int a2 = 9;
        int[] nums3 = {0,3,7,2,2,2,4,5,6,3,4,5,8,4,6,0,1};
        int a3 = 9;
        System.out.println(longestConsecutive(nums1) + " =? " + a1);
        System.out.println(longestConsecutive(nums2) + " =? " + a2);
        System.out.println(longestConsecutive(nums3) + " =? " + a3);


    }
}
