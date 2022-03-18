package com.leetcode;

/**
 * [未解决]
 * leetcode 的 1600 多号题
 * 一群员工有在不同大楼之间转移的请求([0,1],[3,1]等), 要求转移后每栋大楼人数不变,
 * 给定一组这样的请求, 问最大能满足多少个转移请求
 */
public class MaximumRequests {
    int cnt = 0;

    public int maximumRequests(int n, int[][] requests) {
        // 遍历数组, 删去所有相等的数字对(保存到新数组r2[][]中), 如[0,0] [1,1], 并分别使 cnt+1
        // 遍历数组, 将数组按照"from由小到大"的顺序排列
        // 遍历数组, 将数组按照"to由大到小"的顺序排列
        for (int i = 0; i <= n; i++) {
            if (requests[i][0] == requests[i][1]) {
                cnt++;
                continue;
            }
            MyNode node = new MyNode();
            node.val = requests[i];
        }

        // 遍历数组, 从requests[0]开始, 循环匹配
        return 1;
    }
}

class MyNode {
    int[] val;
    MyNode pre;
    MyNode next;

    public void MyNode() {

    }

    public void MyNode(int[] val, MyNode pre, MyNode next) {
        this.val = val;
        this.next = null;
        this.pre = null;
    }
}

