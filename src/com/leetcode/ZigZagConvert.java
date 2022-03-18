package com.leetcode;

/**
 * zigzag 行文
 * ABCD 2行, 变为:
 * A D
 * B C
 * 3行, 变为:
 * A
 * B D
 * C
 *
 */
public class ZigZagConvert {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int subLength = 2 * numRows - 2;
        StringBuffer ans  = new StringBuffer();
        for (int row = 0; row < numRows; row++) {
            for (int cRow = 0; cRow < s.length() - row; cRow += subLength) {
                ans.append(s.charAt(cRow + row));
                if (row > 0 && row < (numRows-1) && (cRow + subLength - row) < s.length()) {
                    ans.append(s.charAt(cRow + subLength - row));
                }
            }
        }
        return ans.toString();
    }

    void test() {
        String test1 = "PAYPALISHIRING";
        System.out.println(convert(test1, 4));
        System.out.println(convert("ABCD", 3));

    }
}
