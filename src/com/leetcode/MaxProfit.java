package com.leetcode;

public class MaxProfit {
    public int maxProfit_1(int[] prices) {
        int length = prices.length;
        if (length <= 1) return 0;
        int maxProf = 0;
        int historyMin = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < historyMin) {
                historyMin = price;
            } else if (price - historyMin > maxProf) {
                maxProf = price - historyMin;
            }
        }

        return maxProf;
    }


    void test() {

        System.out.println(maxProfit_1(new int[]{7, 1, 5, 3, 6, 4}) + " == 5");
        System.out.println(maxProfit_1(new int[]{1, 5, 3, 6, 4}) + " == 5");
        System.out.println(maxProfit_1(new int[]{1, 2, 3, 4, 4}) + " == 3");
        System.out.println(maxProfit_1(new int[]{6, 5, 4, 3}) + " == 0");
        System.out.println(maxProfit_1(new int[]{1}) + " == 0");
        System.out.println(maxProfit_1(new int[]{}) + " == 0");
        System.out.println(maxProfit_1(new int[]{1, 5}) + " == 4");
    }

    int maxProfit_1_2(int[] prices) {
        int length = prices.length;
        if (length <= 1) return 0;
        int[][] dp = new int[length][2];

        for (int i = 0; i < length; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = Integer.MIN_VALUE;
                continue;
            }
            // dp[i][0] 中, 0 表示当前持有股票; 此时可以选择"不卖"/"卖", 卖出获取的利润是今天的卖出价格-之前购买时的最小价格(dp[i][1]<=0)
            dp[i][0] = Math.max(dp[i - 1][0], prices[i] + dp[i - 1][1]);
            // dp[i][1] 中, 1 表示当前未持有股票; 此时可以选择"不买"/"买": 买花费 price[i], 不买的花费仍为之前未买时的最大花费
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }

        return dp[length - 1][0];
    }

    int maxProfit_2(int[] prices) {
        int length = prices.length;
        if (length <= 1) return 0;
        int[][] dp = new int[length][2];
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[0];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);

        }

        return dp[length - 1][0];
    }


    // ???
    int maxProfit_2_2(int[] prices) {
        int length = prices.length;
        if (length <= 1) return 0;
        int dp_i_0 = 0, dp_i_1 = -prices[0], temp = 0;
        for (int price : prices) {
            temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + price);
            dp_i_1 = Math.max(dp_i_1, temp - price);

        }

        return dp_i_0;
    }

}
