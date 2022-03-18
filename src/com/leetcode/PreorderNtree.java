package com.leetcode;

import java.util.*;

public class PreorderNtree {


    List<Integer> ans = new ArrayList<>();

    public List<Integer> preorder(Node root) {

        // 递归
//        preorderNtree(root);

        // 迭代. 模拟栈
        preorderNtreeStack(root);

        return ans;
    }

    private void preorderNtreeStack(Node root) {
        if (root==null) return;
        Deque<Node> stack = new ArrayDeque<>();
        List<Node> children = root.children;
        HashMap<Node, Integer> visitedMap = new HashMap<>();
        Node node = root;

        while(!stack.isEmpty() || node!=null) {
            // 从 root 开始, 将第一个子节点加入栈
            while(node!=null) {
                ans.add(node.val);
                stack.push(node);
                // 如果该节点还有子节点, 则将该节点加入 hashmap. 然后继续将其第一个子节点加入栈
                if(node.children != null && node.children.size() > 0) {
                    visitedMap.put(node, 0);
                    node = node.children.get(0);
                } else {  // 如果该节点没有子节点, 则退出本 while
                    node = null;
                }
            }

            node = stack.peek();
            // 判断栈顶节点的下一个未遍历子节点的编号, 当然, 该编号可能超出子节点范围
            int childIndexOfFather = visitedMap.getOrDefault(node, -1) + 1;
            // 判断是否超出子节点范围.
            // 若未超出, 则遍历下一个子节点node.children.get(childIndexOfFather);
            // 若超出, 说明该节点的子节点已遍历完成, 出栈, 从map中移除
            if(node.children != null && childIndexOfFather < node.children.size()) {
                visitedMap.put(node, childIndexOfFather);
                node = node.children.get(childIndexOfFather);
            } else {
                node = stack.pop();
                visitedMap.remove(node);
                node = null;
            }

        }

    }


    void preorderNtree(Node node) {
        // node 为叶子节点, 添加其 val, 返回
        if (node == null) {
            return;
        }
        ans.add(node.val);
        // node 不是叶子节点, 添加其值并前序遍历子节点
        for (Node child : node.children) {
            preorderNtree(child);
        }

    }


    void test() {
        Node c1 = new Node(1);
        Node c2 = new Node(2);
        Node c3 = new Node(3, null);
        Node c4 = null;
        List<Node> cs = new ArrayList<>();
        cs.add(c1);
        cs.add(c2);
        cs.add(c3);
        Node root = new Node(9, cs);

        for (Node c : root.children) {
            System.out.println(root.children.get(0).val);
        }
    }

}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
