package com.lp.leetcode.link;

import java.util.HashSet;

public class LeetCode141 {

    public boolean hasCycle(ListNode head) {

        HashSet<Integer> set = new HashSet<>();

        if (head == null || head.next == null) {// 单节点
            return false;
        }

        while (true) {
            boolean addR = set.add(head.hashCode());
            if (!addR) {
                return true;
            }
            head = head.next;
            if (head == null) {
                return false;
            }
        }
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}



