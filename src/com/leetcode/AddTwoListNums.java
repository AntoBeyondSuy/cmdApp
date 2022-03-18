package com.leetcode;

/**
 * [2,4,3]
 * [5,6,4]
 */
public class AddTwoListNums {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        ListNode startNode = new ListNode();
        ListNode nextNode = startNode;

        while (l1 != null || l2 != null || sum > 0) {
            sum += (l1==null?0:l1.val) + (l2==null?0:l2.val);
            nextNode.next = new ListNode(sum%10);
            nextNode = nextNode.next;
            sum /= 10;
            l1 = (l1 == null)? null:l1.next;
            l2 = (l2 == null)? null:l2.next;

        }
        return startNode.next;
    }

    void printListNode(ListNode head) {
        while (head.next != null) {
            System.out.print(head.val + ", ");
        }
    }

    void test() {

    }
}


/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */



