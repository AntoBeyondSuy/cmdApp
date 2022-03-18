package com.leetcode;

public class TrapRain {

    public int trap(int[] height) {
//        int start = 0;
//        while (start < height.length && height[start] == 0) {
//            start++;
//        }
//        if (start >= height.length) return 0;
//        // 从第一个不是 0 的墙开始
//        traprain(height, start);
//        return rain;
        int rain = 0;
        int n = height.length;
        if (n <= 2) return 0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];
        for (int i = 1; i < n - 1; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            rightMax[n - i - 1] = Math.max(rightMax[n - i], height[n - i - 1]);
        }
        leftMax[n-1] = leftMax[n-2];
        rightMax[0] = rightMax[1];
        for (int j = 1; j < n-1; j++) {
            rain += Math.min(leftMax[j], rightMax[j]) - height[j];
        }

        return rain;

    }


    int traprain(int[] height, int start) {
        if (start >= height.length - 1) return 0;
        int leftWall = height[start];
        for (int i = start + 1; i < height.length; i++) {
            if (height[i] < leftWall) {
                if (i == height.length - 1) {
                    traprain(height, start + 1);
                    break;
                }
                continue;  // 没有墙, 跳过
            }
            // 向右遍历过程中 遇到了 比当前左墙更高的, 开始计算"当前左墙到该位置墙"之间的 rain
            if (height[i] >= leftWall) {
                if (i == start + 1) {
                    traprain(height, i);
                    break;
                }
//                rain += countRain(height, start, i);
                traprain(height, i);
                break;
            }
            // 向右遍历过程中 没有遇到 比当前左墙更高的, start+1, 从下一个墙开始遍历
            //            traprain(height, i+1);
            //            break;
        }
        return 0;
    }

    int countRain(int[] height, int leftWall, int rightWall) {

        int full = Math.min(height[leftWall], height[rightWall]) * (rightWall - leftWall - 1);
        for (int i = leftWall + 1; i < rightWall; i++) {
            full -= height[i];
        }

        return full;
    }


    void test() {
        int[] wall1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] wall2 = {1, 0, 0, 0, 1};
        int[] wall3 = {1, 2, 3, 4, 5};
        int[] wall4 = {5, 4, 3, 2, 1};
        int[] wall5 = {3, 2, 1, 2, 3};

        System.out.println(trap(wall1) + " == 6");
        System.out.println(trap(wall2) + " == 3");
        System.out.println(trap(wall3) + " == 0");
        System.out.println(trap(wall4) + " == 0");
        System.out.println(trap(wall5) + " == 4");
    }
}
