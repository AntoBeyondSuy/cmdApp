package com.leetcode;

import java.util.ArrayDeque;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        ArrayDeque<String> deque = new ArrayDeque<>();
        for (String dir : dirs) {
            if ("".equals(dir) || ".".equals(dir)) continue;
            if("..".equals(dir)) {
                deque.pollLast();
                continue;
            }
            deque.addLast(dir);
        }
        StringBuilder sb = new StringBuilder();
        String val = deque.pollFirst();
        if(val == null) return "/";
        while (val != null) {
            sb.append("/").append(val);
            val = deque.pollFirst();
        }
        return sb.toString();
    }

    void test () {
        String t1 = "/aa//bb//.././.../";
        String a1 = "/aa/...";
        String t2 = "/";
        String a2 = "/";
        String t3 = "///////////";
        String a3 = "/";
        String t4 = "/..";
        String a4 = "/";
        String t5 = "/./././../";
        String a5 = "/";
        System.out.println(simplifyPath(t1) + " == " + a1);
        System.out.println(simplifyPath(t2) + " == " + a2);
        System.out.println(simplifyPath(t3) + " == " + a3);
        System.out.println(simplifyPath(t4) + " == " + a4);
        System.out.println(simplifyPath(t5) + " == " + a5);

    }
}
