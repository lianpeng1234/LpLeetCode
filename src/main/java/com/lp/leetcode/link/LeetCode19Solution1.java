package com.lp.leetcode.link;

public class LeetCode19Solution1 {

    //    1->2->3->4->5, 和 n = 2
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode initialHead = head;

        // 计算链表的长度
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }

        // 计算目标值的下标
        int target = length - n;
        if (target < 0) {// 要删除的节点，超出链表长度范围
            return null;
        }

        // 链表长度是1，并且 删除这唯一的节点
        if (length == 1 && target == 0) {
            return null;
        }

        // 删除头节点
        if (target == 0) {
            return initialHead.next;
        }

        ListNode delete = initialHead;

        // 删除头节点以后的节点   1->2->3->4->5, n = 3，target = 2
        int index = 0;
        ListNode pre = null;
        while (delete != null) {
            if (index == target) {
                pre.next = delete.next;
                return initialHead;
            }
            pre = delete;
            delete = delete.next;
            index++;
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



