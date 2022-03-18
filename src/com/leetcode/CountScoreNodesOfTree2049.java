package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CountScoreNodesOfTree2049 {
    long maxScore = 0;
    int appearTime = 0, score = 0;
    ArrayList[] children;

    public int countHighestScoreNodes(int[] parents) {

        // 后序遍历树, 将每个节点的左右子树的大小(即节点数量)保存在 map 中
        // 遍历数组, 对每个节点(如node), 该节点的 score 为"从树中减裁掉该节点后, 剩余所有非空子树的大小的乘积"
        // 可以计算为: ((node 的父节点的左右子树大小和+1) - (node的左右子树大小和+1)) * node的左子树大小 * node的右子树大小
        // = (父节点左 + 父节点右 - node左 - node右) * node左 * node右
        // 得到得分后与 maxScore 比较, 若等于则 appearTime++, 大于则appearTime=1, 小于则跳过
        int l = parents.length;
        children = new ArrayList[l];
        for (int i = 0; i < l; i++) {
            children[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < l; i++) {
            int p = parents[i];

            if (p != -1) children[p].add(i);
        }

        dfs(0);

        return appearTime;

    }

    int dfs(int node) {



        return 1;

    }
}
