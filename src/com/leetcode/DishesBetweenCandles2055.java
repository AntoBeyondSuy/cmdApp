package com.leetcode;

import javax.swing.plaf.IconUIResource;

/**
 * 输入：s = "**|**|***|", queries = [[2,5],[5,9]]
 * 输出：[2,3]
 * 解释：
 * - queries[0] 有两个盘子在蜡烛之间。
 * - queries[1] 有三个盘子在蜡烛之间
 * <p>
 * 输入：s = "***|**|*****|**||**|*", queries = [[1,17],[4,5],[14,17],[5,11],[15,16]]
 * 输出：[9,0,0,0,0]
 * 解释：
 * - queries[0] 有 9 个盘子在蜡烛之间。
 * - 另一个查询没有盘子在蜡烛之间。
 */
public class DishesBetweenCandles2055 {
    /*
    记录每一个盘子之前的蜡烛数量, 这样的话只需要后面的盘子减去前面的盘子就能得到二者之间的蜡烛数量,
    之后的每次查询, 时间复杂度均为 O(1)
    0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20 21 22
    *  *  *  |  *  *  |  *  *  *  *  *  |  *  *  |  |  *  *  |  *  *  *
    0  0  0  0        2                 7        9  9       11
    0  0  0  0  0  0  2  2  2  2  2  2  7  7  7  9  9  9  9 11 11 11 11     left
    0  0  0  0  2  2  2  7  7  7  7  7  7  9  9  9  9 11 11 11 23 23 23     right
    任意两个位置 i j 之间的盘子数量为 left[j]-right[i], 如 5,14:  7-2=5
    */
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int slen = s.length();
        int n = 0;
        boolean hasLeftCandle = false;
        int[] ans = new int[queries.length];
        int[] left = new int[slen];
        int[] right = new int[slen];

        // 计算每个蜡烛左侧的盘子数量, 并保存 left
        for (int i = 0; i < slen; i++) {
            if (!hasLeftCandle) {
                if ('|' == s.charAt(i)) hasLeftCandle = true;
                left[i] = 0;
                right[i] = 0;
            } else if ('*' == s.charAt(i)) {  // 如果是盘子且左边有蜡烛
                n++;
                left[i] = left[i - 1];
            } else {  // 如果是蜡烛
                left[i] = n;
                right[i] = n;
            }
        }

        boolean hasRightCandle = false;
        // 保存 right
        for (int j = slen - 1; j > 0; j--) {
            if (!hasRightCandle) {
                if ('|' == s.charAt(j)) {
                    hasRightCandle = true;
                } else {
                    right[j] = slen;
                }
            } else if ('*' == s.charAt(j)) {  // 如果是盘子
                right[j] = right[j + 1];
            }
        }

        // 执行查询
        int a = 0;
        for (int[] query : queries) {
            int ansi = left[query[1]] - right[query[0]];
            ans[a++] = Math.max(ansi, 0);
            System.out.println(ans[a-1]);
        }

        return ans;
    }

    void test() {
        String t1 = "**|*******************|**********************************************|************|*********|*****|*********************************************************************************************|***";
        int[][] q1 = new int[][]{{31,96},{14,192},{0,180},{13,193},{12,192},{11,183},{12,189},{65,116},{55,160},{100,164},{6,183},{4,182},{15,183},{0,194},{37,63},{10,184},{0,183},{5,184},{8,185},{13,136},{6,192},{5,189},{13,183},{8,184},{15,188},{0,184},{9,191},{4,193},{61,83},{1,193},{10,194},{15,192},{13,184},{2,185},{11,190},{11,195},{14,188},{12,188},{94,116},{3,184},{0,189},{4,185},{12,193},{3,185},{1,181},{6,194},{0,185},{10,193},{5,187},{10,185},{12,182},{23,80},{10,191},{10,195},{13,189},{6,193},{5,183},{2,182},{14,181},{3,187},{9,187},{4,180},{5,190},{4,181},{7,184},{3,135},{6,189},{14,186},{5,195},{11,186},{8,186},{30,159},{11,192},{61,80},{3,181},{5,192},{10,187},{2,25},{9,194},{43,118},{2,189},{8,180},{15,193},{13,181},{14,182},{105,133},{8,195},{0,193},{13,192},{3,186},{1,189},{24,124},{0,181},{136,158},{11,193},{14,180},{11,180},{54,149},{8,191},{11,188},{4,188},{2,181},{5,188},{11,181},{43,175},{12,183},{0,186},{6,188},{0,191},{15,186},{8,187},{7,74},{3,180},{27,149},{73,153},{52,145},{9,188},{7,195},{14,193},{77,160},{0,187},{10,188},{4,187},{62,160},{13,190},{12,190},{5,191},{14,184},{9,186},{7,189},{131,148},{9,189},{159,179},{20,174},{13,180},{4,184},{0,192},{2,190},{0,195},{10,180},{9,182},{9,181},{11,194},{12,194},{5,185},{3,189},{118,160},{5,181},{14,122},{25,63},{11,189},{3,193},{31,176},{58,148},{9,183},{11,184},{35,181},{12,186},{14,190},{8,190},{15,194},{1,195},{4,194},{2,180},{9,190},{3,182},{15,181},{13,194},{6,182},{42,117},{4,186},{13,187},{25,103},{6,184},{5,180},{21,180},{1,187},{15,189},{6,180},{44,160},{8,182},{15,180},{10,182},{1,180},{7,185},{8,193}};
//        String t1 = "***|***||||***||***";
//        int[][] q1 = new int[][]{{0,9},{3,7},{0,18},{2,15},{7,9}};
        platesBetweenCandles(t1, q1);
    }



    /* 暴力解, 每次查询都需要计算, 时间复杂度太高
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] ans = new int[queries.length];
        // s 转换为 1 0 字符串, **||** -> 110011
        String trans01 = trans2ZeroOne(s);

        // 循环查询
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int ansi = (right - left < 2) ? 0 : queryPlates(trans01, left, right);
            ans[i] = ansi;
        }
        for (int i = 0; i < queries.length; i++) {
            System.out.print(ans[i] + ",");
        }
        return ans;
    }

    private int queryPlates(String trans01, int left, int right) {
        // 1. 截取 left ~ right 之间的字串
        String sub1_trans01 = trans01.substring(left, right + 1);
        // 2. 截取该子串从第一个0到最后一个0之间的字串
        // 如果最后一位是 0 (蜡烛), 则需要包含进去, 即只指定截取的起始位置; 否则指定截取末位为末尾0的index+1
        int firstCandle = sub1_trans01.indexOf("0");
        if(firstCandle==-1) return 0;
        int lastCandle = sub1_trans01.lastIndexOf("0");
        if(lastCandle==firstCandle) return 0;
        boolean subLast = lastCandle == sub1_trans01.length() - 1;
        String sub2_trans01 = sub1_trans01.substring(firstCandle);
        if (!subLast) {
            sub2_trans01 = sub1_trans01.substring(sub1_trans01.indexOf("0"), sub1_trans01.lastIndexOf("0") + 1);
        }

        // 3. 至此已经取出了最后的结果, 计算该子串包含几个1即为答案
        int ans = countOne(sub2_trans01);
        System.out.println("queryPlates: " + ans);
        return ans;
    }

    private int countOne(String sub2_trans01) {
        int ans = 0;
        for (char c : sub2_trans01.toCharArray()) {
            ans += (c-48);
        }
        System.out.println("countOne: " + sub2_trans01 + "->" + ans);
        return ans;
    }

    // s 转换为 1 0 字符串, **||** -> 110011
    private String trans2ZeroOne(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c=='*'?1:0);
        }
        System.out.println("trans2ZeroOne: " + s + "->" + sb.toString());
        return sb.toString();
    }
    */
}
