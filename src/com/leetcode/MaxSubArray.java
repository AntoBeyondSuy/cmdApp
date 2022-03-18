package com.leetcode;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n==1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i=1; i<n; i++) {
            if(dp[i-1]>0) {
                dp[i] = dp[i-1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }

        int ans = dp[0];
        for(int j=0; j<n; j++) {
            ans = Math.max(ans, dp[j]);
        }
        return ans;
    }

    int maxSubArray2(int[] nums) {
        int pre = 0;
        int maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }

        return maxAns;
    }

    void test() {
        int[] n1 = {-2,1,-3,4,-1,2,1,-5,4};
        int[] n2 = {1};
        int[] n3 = {5,4,-1,7,8};
        int[] n4 = {-1,-1,-1,-2,-1};

        System.out.println(maxSubArray(n1) + " == " + maxSubArray2(n1) + " == 6");
        System.out.println(maxSubArray(n2) + " == " + maxSubArray2(n2) + " == 1");
        System.out.println(maxSubArray(n3) + " == " + maxSubArray2(n3) + " == 23");
        System.out.println(maxSubArray(n4) + " == " + maxSubArray2(n4) + " == -1");
    }
}
