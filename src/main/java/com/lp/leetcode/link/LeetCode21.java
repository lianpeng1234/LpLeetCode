package com.lp.leetcode.link;

/**
 * 题目编号 21
 * 合并两个有序链表
 */
public class LeetCode21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = null;
        ListNode tmp = null;


        while (true) {
            if (l1 == null) {
                if (newHead == null) {
                    newHead = l2;
                } else {
                    tmp.next = l2;
                }
                break;
            }

            if (l2 == null) {
                if (newHead == null) {
                    newHead = l1;
                } else {
                    tmp.next = l1;
                }
                break;
            }

            if (l1.val <= l2.val) {
                if (newHead == null) {
                    newHead = l1;
                }

                if (tmp == null) {
                    tmp = l1;
                    l1 = l1.next;
                } else {
                    tmp.next = l1;
                    tmp = l1;
                    l1 = l1.next;
                }

            } else {
                if (newHead == null) {
                    newHead = l2;
                }

                if (tmp == null) {
                    tmp = l2;
                    l2 = l2.next;
                } else {
                    tmp.next = l2;
                    tmp = l2;
                    l2 = l2.next;
                }
            }
        }

        return newHead;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}



