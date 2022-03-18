package com.leetcode;

/**
 * 倒序输出句子中的单词, 不能有多余空格
 * 如:s = "the sky is blue" -> "blue is sky the"
 */
public class ReverseWordsInSen {
    public String reverseWords(String s) {
        String[] s2 = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = s2.length - 1; i >= 0; i--) {
            if ("".equals(s2[i])) continue;
            sb.append(s2[i]);
            if (i > 0) sb.append(" ");
        }
        return sb.toString();
    }

    void test() {
        String s1 = "   abc   def   xyz";
        String s2 = "a b c";
        System.out.println("\"" + reverseWords(s1) + "\"");
        System.out.println("\"" + reverseWords(s2) + "\"");

    }
}
