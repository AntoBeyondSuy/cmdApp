package com.leetcode;

/**
 * 123 -> 321
 * -123 -> -321
 * 但是只能用 32 位的数据类型保存, 不能用 long 等保存数据.
 * 即不能超过[Integer.MIN_VALUE, Integer.MAX_VALUE]的范围
 */
public class ReverseInteger {
    public int reverse(int x) {
        int digit, ans = 0;
        while (x != 0) {
            if (ans < Integer.MIN_VALUE / 10 || ans > Integer.MAX_VALUE / 10) {
                return 0;
            }
            digit = x % 10;
            x /= 10;
            ans = ans * 10 + digit;
        }

        return ans;
    }

    void test(int ori, int rev) {
        System.out.println(reverse(ori) + ", =" + rev);
    }


}
