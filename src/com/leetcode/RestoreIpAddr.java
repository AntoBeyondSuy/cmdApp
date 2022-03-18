package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestoreIpAddr {
    static int IPv4_SEG_COUNT = 4;
    static int IPv4_ADD_MAX_LENGTH = 3;
    List<String> ips;
    List<String> ipNums;

    public List<String> restoreIpAddresses(String s) {
        int slength = s.length();
        ips = new ArrayList<>();
        ipNums = new ArrayList<>();
        if (slength <= 3 || slength >= 13) return ips;

        // 此时 s 的长度在 4~12 之间. 遍历每个数字, 并且递归
        dfs(s, 0, 0);


//        Map<Integer, Integer> dotPosition = new HashMap<>();
//        dotPosition.put(0, -1);
//        dotPosition.put(1, -1);
//        dotPosition.put(2, -1);
//        judgeDot(sArray, 0, 0, 0, dotPosition);  // doti = 1; 插入第一个点

        return ips;
    }

    void dfs(String s, int segId, int segStart) {
        // 准备分出第5段, 当然第5段是不合法的, 此处只是为了判断是否已经分出了4段, 若是则进一步判断
        if (segId == IPv4_SEG_COUNT) {
            if (segStart == s.length()) {  // 枚举结束, 满足条件, 添加当前的地址到结果list中
                ips.add(String.join(".", ipNums));
                return;
            }
        }

        // 剩余数字个数超过(3*剩余点数)个, 已经已经不满足条件, 直接剪枝返回
        if (s.length() - segStart > IPv4_ADD_MAX_LENGTH * (IPv4_SEG_COUNT - segId)) {
            return;
        }

        // 一般判断, 当前ip字段是否满足要求
        for (int i = segStart; i < s.length(); i++) {
            if (!isValidIpSeg(s.substring(segStart, i + 1))) {
                continue;
            }
            ipNums.add(s.substring(segStart, i + 1));
            dfs(s, segId + 1, i + 1);
            ipNums.remove(ipNums.size() - 1);
        }

    }

    boolean isValidIpSeg(String substr) {
        if (!substr.matches("0|[^0]\\d{0,2}")) {
            return false;
        }
        int ipNum = Integer.parseInt(substr);
        return 0 <= ipNum && 255 >= ipNum;

    }


    /*
     * @param sArray 未加点的 IP 地址数字串
     * @param num    保存当前的地址段的数字, 应在 [0, 255] 之内
     * @param index  当前遍历到的数字的下标, [0, sArray.length-1]
     * @param dotnum 已添加的点的数量
     */
//    void judgeDot(char[] sArray, int num, int index, int dotnum, Map<Integer, Integer> dotPosition) {
//        if (dotnum == 2) {
//            if (sArray.length - index <= 4) { // 满足条件, 输出
//                ans2ListString(sArray, dotPosition);
//            }
//            return;
//        }
//        if (dotnum < (4 - index + sArray.length)) {  // 剩余间隙数量 < 剩余的 dot 数量, 无法容纳, 返回
//            return;
//        }
//        int numIndex = sArray[index] - 48;
//        if (numIndex == 0 && num == 0) {  // 如果 index 位置的数字(即当前遍历到的)是 0 且当前保存的 num 也是 0 , 则直接加 dot
//            dotPosition.put(dotnum, index);  // 在 index 所在位置(数字0)放一个 dot
//            judgeDot(sArray, 0, index + 1, dotnum + 1, dotPosition);
//            // dotPosition.put(dotnum, -1);  // 删去 index 所在位置的 dot
//        } else if (numIndex == 0 && num < 26) {  // 如果 index 位置的数字(即当前遍历到的)是 0, 而当前保存的 num 属于[1,25] , 则增加 num
//            num = 10 * num;  // num 为 10, 20, ..., 240, 250
//            judgeDot(sArray, num, index + 1, dotnum, dotPosition);  // 直接遍历下一个数字
//        } else if (num >= 26) {  // 当前数字 numIndex 不为0, 但 num 乘 10 后大于 255, 不能再扩大, 故在此处加 dot
//            dotPosition.put(dotnum, index);
//            judgeDot(sArray, 0, index + 1, dotnum + 1, dotPosition);
//            // dotPosition.put(dotnum, -1);
//        } else if (numIndex <= 5 && num == 25) {  // 当前数字 numIndex 不为0, 而 num 可以扩大为 [251, 255], 在此位置加 dot
//            num = 10 * num + numIndex;  // num 为 251, 252, 253, 254, 255
//            dotPosition.put(dotnum, index);
//            judgeDot(sArray, 0, index + 1, dotnum + 1, dotPosition);
//            // dotPosition.put(dotnum, -1);
//        } else if (num < 25) { // 当前数字 numIndex为[1,9], 且 num 可以 [0,24]->[1,249], 直接判断下一个数字
//            num = 10 * num + numIndex;
//            judgeDot(sArray, num, index + 1, dotnum, dotPosition);
//        }
//
//    }
//
    void printListString(List<String> toPrint) {
        for (String s : toPrint) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    void test() {
        String t1 = "1004";
        String a1 = "1.0.0.4";
        String t2 = "255255255255";
        String a2 = "255.255.255.255";
        String t3 = "100912123";
        String a3 = "100.9.12.1.23";
        String t4 = "100100100256";
        String a4 = "";

        printListString(restoreIpAddresses(t1));
        System.out.println(" == " + a1);
        printListString(restoreIpAddresses(t2));
        System.out.println(" == " + a2);
        printListString(restoreIpAddresses(t3));
        System.out.println(" == " + a3);
        printListString(restoreIpAddresses(t4));
        System.out.println(" == " + a4);
    }
}
