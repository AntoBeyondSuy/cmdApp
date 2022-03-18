package com.leetcode;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;  // cur 一直指向合并好的List中最小的值
        while (list1 != null && list2 != null) {

            // 两个链表的节点都不为 null
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;

            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;

        }
        cur.next = list1 == null ? list2 : list1;

        return head.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {

        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = (right + left) >> 1;
        return mergeTwoLists(merge(lists, left, mid), merge(lists, mid + 1, right));

    }
}
