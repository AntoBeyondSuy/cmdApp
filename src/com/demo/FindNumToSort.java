package com.demo;

/**
 * 给定遗传字符串, 1<=长度<1010, 包含大小写字母/数字, 要求提取出其中的数, 并按由小到大顺序输出
 * String s1 = "He15fx154xo87ujs7y87d";
 * String ans1 = "7, 15, 87, 87, 154";
 */
public class FindNumToSort {
    public void findNumToSort(String s) {
        int num = 0;
        int tmp;
        LinkedNode head = new LinkedNode(0);
        for (int i = 0; i < s.length(); i++) {
            tmp = s.charAt(i);
            if (tmp >= 48 && tmp <= 57) {  // 如果是数字 0~9
                num = num * 10 + (tmp-48);  // 生成数
            } else {  // 如果是字母, 则判断当前存储的数是否大于零, 若是则可以输出
                if (num > 0) {
                    sortLinkedList(head, num);
                    num = 0;
                }
            }
        }
        if (num > 0) sortLinkedList(head, num);
        printLinkedList(head);
    }

    LinkedNode sortLinkedList (LinkedNode head, int newVal) {
        LinkedNode tmp = head;
        while (tmp.next != null) {
            if (tmp.next.val >= newVal) {
                LinkedNode node = new LinkedNode(newVal, tmp.next);
                tmp.next = node;
                return head;
            }
            tmp = tmp.next;
        }
        tmp.next = new LinkedNode(newVal);
        return head;
    }

    void printLinkedList(LinkedNode head) {
        head = head.next;
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public void test() {
        String s1 = "He15fx154xo87ujs7y87d";
        String ans1 = "7, 15, 87, 87, 154";
        String s2 = "aaa00000aaaa00002aaaa1";
        String ans2 = "1, 2";
        String s3 = "9";
        String ans3 = "9";

        LinkedNode node0 = new LinkedNode(0);
//        LinkedNode node1 = new LinkedNode(1);
//        LinkedNode node2 = new LinkedNode(2);
//        LinkedNode node3 = new LinkedNode(3);
//        LinkedNode node4 = new LinkedNode(4);
//        node0.next = node1;
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;

        System.out.println("- - - - -");
        findNumToSort(s1);
        System.out.println(ans1);
        System.out.println("- - - - -");
        findNumToSort(s2);
        System.out.println(ans2);
        System.out.println("- - - - -");
        findNumToSort(s3);
        System.out.println(ans3);

    }
}


class LinkedNode {
    int val;
    LinkedNode next;

    public LinkedNode(int val) {
        this.val = val;
        this.next = null;
    }

    public LinkedNode(int val, LinkedNode next) {
        this.val = val;
        this.next = next;
    }
}