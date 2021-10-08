package com.lp.leetcode.link;

/**
 * 两数相加
 */
public class LeetCode2Solution1 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode sumMove = dummyHead;
        boolean carryBit = false;

        while (true) {
            if(l1 == null && l2 == null && !carryBit) {
                break;
            }

            // 取节点值
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;

            // 移动链表
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;

            int sum = l1Val + l2Val;
            if (carryBit) {
                sum++;
            }

            int remainder = 0;
            if (sum > 9) {// 两节点值，之和大于 10
                remainder = sum % 10;
                // 进位 1
                carryBit = true;
            } else {
                remainder = sum;
                carryBit = false;
            }

            sumMove.next = new ListNode(remainder);
            sumMove = sumMove.next;
        }

        return dummyHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}



