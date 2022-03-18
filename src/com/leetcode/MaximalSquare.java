package com.leetcode;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if(0==m) return 0;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (0 == i || 0 == j) {
                    dp[i][j] = matrix[i][j] - 48;
                    ans = Math.max(ans, dp[i][j]);
                    continue;
                }
                int m_ij = matrix[i][j] - 48;
                if (0 == m_ij) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                ans = Math.max(ans, dp[i][j]);
            }
        }

//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(dp[i][j]);
//            }
//            System.out.println();
//        }
        return ans*ans;
    }



    void test() {
        char[][] matrix1 = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        int ans1 = 4;
        char[][] matrix2 = {{'1', '1', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '1', '1', '1', '1'}};
        int ans2 = 16;
        char[][] matrix3 = {{'1', '1', '1', '1', '1'}, {'1', '0', '0', '0', '0'}, {'1', '0', '0', '0', '0'},{'1', '0', '0', '0', '0'},{'1', '0', '0', '0', '0'}};
        int ans3 = 1;
        char[][] matrix4 = {{'0'}};
        int ans4 = 0;
        System.out.println(maximalSquare(matrix1) + " ==? " + ans1);
        System.out.println(maximalSquare(matrix2) + " ==? " + ans2);
        System.out.println(maximalSquare(matrix3) + " ==? " + ans3);
        System.out.println(maximalSquare(matrix4) + " ==? " + ans4);
    }
}
