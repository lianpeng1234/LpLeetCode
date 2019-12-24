package com.lp.leetcode.link;

import java.util.ArrayList;
import java.util.List;

public class LeetCode21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        // 将连个链表转换为数组
        List<Integer> list = new ArrayList<>();
        while (l1 != null) {
            list.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            list.add(l2.val);
            l2 = l2.next;
        }

        // 冒泡排序
        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (list.get(i) > list.get(j)) {
                    int tmp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, tmp);
                }
            }
        }

        // 将数组转换为链表
        ListNode head = new ListNode(list.get(0));
        ListNode cur = head;
        for (int i = 1; i < size; i++) {
            ListNode node = new ListNode(list.get(i));
            cur.next = node;
            cur = node;
        }
        return head;

    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}



