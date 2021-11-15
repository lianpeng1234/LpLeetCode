package com.lp.leetcode.stack;

import java.util.ArrayList;
import java.util.List;

public class LeetCode143 {
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();

        while (head != null) {
            list.add(head);
            head = head.next;
        }

        int begin = 0;
        int end = list.size() - 1;
        while (begin <= end) {
            ListNode before = list.get(begin);
            ListNode after = list.get(end);
            if (begin < end) {
                before.next = after;
            }

            if (begin != 0) {
                head.next = before;
            }
            head = after;
            head.next = null;
            begin++;
            end--;
        }
        head = list.get(0);
    }

    public static class ListNode {
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
