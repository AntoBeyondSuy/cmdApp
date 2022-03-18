package com.leetcode;

import java.util.List;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {

        ListNode cur = null, pre = head;
        while(pre != null) {
            ListNode preNext = pre.next;
            pre.next = cur;
            cur = pre;
            pre = preNext;
        }
        return cur;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
