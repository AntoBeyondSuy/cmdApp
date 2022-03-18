package com.leetcode;

public class MySqrt {
    public int mySqrt(int x) {
        if (x < 2) return x;
        double g = x / 2.0;
        while (Math.abs(g * g - x) > 0.1) {
            g = (g + x / g) / 2;
        }
        return (int)g;
    }
}
