package com.lp.leetcode.link;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LeetCode25 {

    @Test
    public void test() {
        int[] array = new int[]{1};
        ListNode head = new ListNode(array[array.length - 1]);
        for (int i = array.length - 2; i >= 0; i--) {
            ListNode node = new ListNode(array[i]);
            node.next = head;
            head = node;
        }
        reverseKGroup(head, 1);
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        if (list.size() == 1) {
            return list.get(0);
        }

        boolean evenNum = true;
        int times = list.size() / k;
        if (list.size() % k > 0) {
            evenNum = false;
            times++;
        }

        head = list.get(k - 1);

        ListNode tmpHead = head;

        int startIndex = 0;
        int startTimes = 1;

        while (times > 0) {
            if (times == 1 && !evenNum) {
                tmpHead.next = list.get(startIndex);
                break;
            }

            int endIndex = startTimes * k - 1;
            if (endIndex >= list.size()) {
                endIndex = list.size() - 1;
            }
            for (; endIndex >= startIndex; endIndex--) {
                list.get(endIndex).next = null;
                tmpHead.next = list.get(endIndex);
                tmpHead = list.get(endIndex);
            }

            startIndex = startTimes * k;
            startTimes++;
            times--;
        }

        return head;
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
