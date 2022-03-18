package com.leetcode;

import java.util.HashMap;

/**
 * 给定两个字符串 s1 s2, 判断 s1 生成的所有排列字符串是否出现在 s2 中
 * 如: "abc", "abac". 后者包含"bac", 是"abc"的另一种排列
 *
 */
public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        // 建立哈希表, 保存要排列的字符串的所有字符出现的次数
        HashMap<Character, Integer> map = new HashMap<>();
        for (char s: s1.toCharArray()) {
            map.put(s, 1 + map.getOrDefault(s, 0));
        }
        HashMap<Character, Integer> tempMap = new HashMap<>(map);
        int sum = 0;
        for (int val : map.values()) {
            sum += val;
        }
        // 复制哈希表

        // 滑动窗口遍历 s2 的每个字符, 判断当前字符是否在 map 中
        for (int i = 0; i < s2.length(); i++) {
            tempMap = new HashMap<>(map);
            int tempSum = sum;
            int tail = i;
            char ctail = s2.charAt(tail);
            while(tempMap.containsKey(ctail)) {
                tempMap.put(ctail, tempMap.get(ctail)-1);
                if (tempMap.get(ctail) < 0) break;
                if (--tempSum == 0) return true;
                if(++tail == s2.length()) return false;
                ctail = s2.charAt(tail);
            }
        }
        return false;
    }

    void test() {
        System.out.println(checkInclusion("a", "bbbbbba") + ", true");
        System.out.println(checkInclusion("abc", "abac") + ", true");
        System.out.println(checkInclusion("aaa", "bbbbbbbb") + ", false");
        System.out.println(checkInclusion("abc", "bcllllllaclllllca") + ", false");
        System.out.println(checkInclusion("abc", "l") + ", false");
    }
}

// "ab"
// "eidboaoo"

// "adc"
// "dcda"