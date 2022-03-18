package com.leetcode;


public class GetPermutation {

    public String getPermutationRecur(int n, int k) {
        return "";
    }


    public String getPermutation(int n, int k) {
        if (2 == n) {
            return 1 == k ? "12" : "21";
        }
        int[] fac = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        boolean[] usednum = new boolean[n];
        int[] nums = new int[n];
        int[] ans = new int[n];
        int p = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        int slashk = n - 1;
        while (slashk > 0) {
            int j = fac[slashk];
            int index = k % j == 0 ? 0 : k / j;
            while (usednum[index]) index++;
            usednum[index] = true;
//            System.out.print(nums[index]);
            ans[p++] = nums[index];
            k %= j;
            slashk--;
        }

        for (int i = 0; i < n; i++) {
            if (!usednum[i]) ans[p++] = nums[i];
            ;
        }
        StringBuilder sb = new StringBuilder();
        for (int an : ans) {
            sb.append(an);
        }
        return sb.toString();

    }

    int getFactorial(int n) {
        int res = 1;
        while (n > 1) {
            res *= n;
            n--;
        }
        return res;
    }
}
