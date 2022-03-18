package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumZero {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int nlength = nums.length;
        List<List<Integer>> zeroSums = new ArrayList<List<Integer>>();
        for (int first = 0; first < nlength; first++) {
            if(first!=0 && nums[first] == nums[first-1]) continue;

            int target = -nums[first];
            int third = nlength - 1;
            for (int second = first+1; second < nlength; second++) {
                if (second!=first+1 && nums[second] == nums[second-1]) continue;

                while (second<third && nums[second] + nums[third] > target) third--;
                if (second==third) break;
                if(nums[second] + nums[third] == target) {
                    List<Integer> asum = new ArrayList<>();
                    asum.add(nums[first]);
                    asum.add(nums[second]);
                    asum.add(nums[third]);
                    zeroSums.add(asum);
                }
            }
        }

        return zeroSums;
    }

    void test() {
        int[] sums = {-1,0,1,2,-1,-4};
        for (List<Integer> sumList : threeSum(sums)) {
            System.out.print("[");
            for (Integer sum : sumList) {
                System.out.print(sum + ",");
            }
            System.out.print("],");
        }
    }
}
