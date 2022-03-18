package com.leetcode;

/**
 * 找一组字符串的最长公共前缀
 *
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 2) return strs[0];
        int minLen = 200;
        int minIndex = 0;
        for (int i = 0; i < strs.length; i++) {
            if("".equals(strs[i])) return "";
            if (minLen > strs[i].length()) {
                minLen = strs[i].length();
                minIndex = i;
            }
        }
        if(minLen<1) return "";
//        System.out.println(strs[minIndex] + ", " + minLen);  // 长度最小的字符串以及它的长度
        StringBuilder stringBuilder = new StringBuilder();
        boolean colSame = true;
        for (int coli = 0; coli < minLen; coli++) {
            for (String str : strs) {
                if (str.charAt(coli) != strs[minIndex].charAt(coli)) {
//                    stringBuilder.deleteCharAt(coli);
                    colSame = false;
                    break;
                }
            }
            if (colSame) stringBuilder.append(strs[minIndex].charAt(coli));
        }

        return stringBuilder.toString();

    }

    void test() {
//        String[] strs1 = new String[]{"", "", ""};
//        String[] strs2 = new String[]{"a", "b", "c"};
//        String[] strs3 = new String[]{"aaa", "aaaa", "aaaaa"};
//        String[] strs4 = new String[]{"aaaa", "aaab", "aaac"};
        String[] strs5 = new String[]{"abc", "abc", "abc"};
        String[] strs6 = new String[]{"llllllaaaaa", "aaaaallllll", "llllll"};
//        System.out.println(longestCommonPrefix(strs1) + " = " + "");
//        System.out.println(longestCommonPrefix(strs2) + " = " + "");
//        System.out.println(longestCommonPrefix(strs3) + " = " + "aaa");
//        System.out.println(longestCommonPrefix(strs4) + " = " + "aaa");
        System.out.println(longestCommonPrefix(strs5) + " = " + "abc");
        System.out.println(longestCommonPrefix(strs6) + " = " + "");

        // 注意, 可以使用 substring 和 startsWith
        String subs = strs6[0].substring(0, 3);
        System.out.println(strs6[0].startsWith(subs));

    }
}
