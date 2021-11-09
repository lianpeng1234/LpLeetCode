package com.lp.leetcode.other;

public class LeetCode24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return head;
        }

        ListNode returnCode = head.next;

        ListNode pre = null;
        while (true) {// head = 1
            ListNode tmpHead = head;// 1
            ListNode tmp2 = head.next;// 2
            if (tmp2 == null) {
                break;
            }
            ListNode tmp3 = head.next.next;// null
            tmp2.next = head;
            head.next = tmp3;
            head = tmp3;
            if (pre == null) {
                pre = tmpHead;// 3
            } else {
                pre.next = tmp2;
                pre = tmpHead;// 3
            }
            if (head == null) {
                break;
            }
        }

        return returnCode;
    }

    public class ListNode {
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
}
