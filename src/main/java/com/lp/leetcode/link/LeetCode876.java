package com.lp.leetcode.link;

import java.util.List;

public class LeetCode876 {

    public ListNode middleNode(ListNode head) {
        return slowQuick( head);
    }

    // 简单容易理解，可读性好
    private ListNode natural(ListNode head) {
        ListNode saveHead = head;

        // 计算链表长度
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }

        // 获取中间节点的下标
        int center = length / 2;// 1 2 3 4 5 6 7

        // 找出中间节点
        int index = 0;
        head = saveHead;
        while (head != null) {
            if (index == center) {
                return head;
            }
            index++;
            head = head.next;
        }
        return null;
    }

    // 快慢指针
    private ListNode slowQuick(ListNode head) {
        if (head.next == null) {// 单节点
            return head;
        }
        if (head.next.next == null) {// 双节点
            return head.next;
        }

        ListNode slow = head;
        ListNode quick = head;
        while (quick != null) {
            if (quick.next == null) {
                return slow;
            }
            if (quick.next.next == null) {
                return slow.next;
            }
            quick = quick.next.next;
            slow = slow.next;

        }
        return null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}



