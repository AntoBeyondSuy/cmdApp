package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 字符串中最长子串的长度
 * String test1 = "uuuabc    "; int ans1 = 5; ("uabc ")
 */
public class LongestSubstring {
//    public int lengthOfLongestSubstring(String s) {
//        int slength = s.length();
//        if (slength <= 1) return slength;
//        Set<Character> set = new HashSet<Character>();
//        int rightPointer = 0, ans = 0;
//        for (int i = 0; i < slength - 1; i++) {
//            if (i!=0) {
//                set.remove(s.charAt(i-1));
//            }
//            while (rightPointer<slength && !set.contains(s.charAt(rightPointer))) {
//                set.add(s.charAt(rightPointer));
//                rightPointer++;
//            }
//            if (rightPointer == slength) return Math.max(ans, rightPointer-i);
//            ans = Math.max(ans, rightPointer-i);
//        }
//
//        return ans;
//    }

    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        int ans = 0;
        int tail = 0;
        Set<Character> charSet = new HashSet<Character>();
        for(int i = 0; i < s.length(); i++) {
            if(i!=0) charSet.remove(s.charAt(i-1));
            while (tail < s.length() && !charSet.contains(s.charAt(tail))) {
                charSet.add(s.charAt(tail++));
            }
            if(tail == s.length()) return Math.max(ans, tail-i);
            ans = Math.max(ans, tail-i);
        }
        return ans;
    }

    void test() {
        String test1 = "uuuabc    "; int ans1 = 5;
        String test2 = "1234567890"; int ans2 = 10;
        String test3 = ""; int ans3 = 0;
        System.out.println(lengthOfLongestSubstring(test1) + ", " + ans1);
        System.out.println(lengthOfLongestSubstring(test2) + ", " + ans2);
        System.out.println(lengthOfLongestSubstring(test3) + ", " + ans3);
    }
}
