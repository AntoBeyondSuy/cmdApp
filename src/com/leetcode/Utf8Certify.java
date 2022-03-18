package com.leetcode;

public class Utf8Certify {

    public boolean validUtf8(int[] data) {
        int index = 0;
        for (int num : data) {
            System.out.println(Integer.toBinaryString(num));
            if (index == 0) {
                if (0b11110 == num >> 3) index = 3;
                else if (0b1110 == num >> 4) index = 2;
                else if (0b110 == num >> 5) index = 1;
                else if (0b1 == num >> 7) return false;
            } else {
                if (0b10 != num >> 6) return false;
                index--;
            }
        }
        return index==0;

    }


    void test() {
        int[] t1 = new int[]{197,130,1};
        int[] t2 = new int[]{237};
        System.out.println(validUtf8(t2));
    }
}
