package com.leetcode;

import java.util.Arrays;

/**
 * [43 medium]
 * 以字符串格式给出两个数, num1 num2, 长度在 [1,200] 内,
 * 要求不使用直接的大数字乘法来实现二者相乘, 并以字符串格式返回结果.
 * 如:"123" * "456" = "56088"
 *
 */
public class StringMultiply {
    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2)) return "0";
        int len1 = num1.length();
        int len2 = num2.length();
        if(len1 == 1 && 49==num1.charAt(0)) return num2;
        if(len2 == 1 && 49==num2.charAt(0)) return num1;

        int[] ans = new int[401];
        Arrays.fill(ans, 0);
        int index, maxIndex = 0;
        for (int i1 = 0; i1 < len1; i1++) {
            for (int i2 = 0; i2 < len2; i2++) {
                index =len2+len1-i1-i2-2;
                ans[index] += ((int) num1.charAt(i1) - 48)*((int) num2.charAt(i2) - 48);
                maxIndex = Math.max(maxIndex, index);
            }
        }
        return intArray2String(ans, maxIndex+1);
    }

    String intArray2String(int[] ori, int length) {
        StringBuilder sb =new StringBuilder();
        int up2;  // 进位
        for (int i = 0; i < length; i++) {
            up2 = ori[i] / 10;
            ori[i] %= 10;
            ori[i+1] += up2;
            sb.insert(0, ori[i]);
        }
        if(ori[length]>0) sb.insert(0, ori[length]);

        return sb.toString();
    }

    void test() {
        String num11 = "123"; String num12 = "456";
        String num21 = "1"; String num22 = "789";
        String num31 = "789"; String num32 = "0";
        String num41 = "1000000000"; String num42 = "1000000000";
        String num51 = "123456789"; String num52 = "1";
        System.out.println(multiply(num11, num12));
        System.out.println(multiply(num21, num22));
        System.out.println(multiply(num31, num32));
        System.out.println(multiply(num41, num42));
        System.out.println(multiply(num51, num52));
        System.out.println(multiply("2", "3"));
        System.out.println(multiply("0", "789"));
        System.out.println(multiply("9", "9"));

    }
}
