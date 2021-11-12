package com.lp.leetcode.other;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LeetCode61 {

    @Test
    public void test() {
        int[] nums = new int[]{};
        ListNode nodeHead = new ListNode(nums[nums.length - 1]);
        for (int i = nums.length - 2; i >= 0; i--) {
            nodeHead = new ListNode(nums[i], nodeHead);
        }
        ListNode node =  rotateRight(nodeHead, 1);
        System.out.println();
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (k <= 0) {
            return head;
        }
        if(head == null) {
            return head;
        }
        // 将链表转换为数组
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        // 计算需要移动多少个位置
        int move = k % list.size();

        int[] moveList = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            int xx = (i + move) % list.size();
            moveList[xx] = list.get(i);
        }

        ListNode nodeHead = new ListNode(moveList[moveList.length - 1]);
        for (int i = moveList.length - 2; i >= 0; i--) {
            nodeHead = new ListNode(moveList[i], nodeHead);
        }
        return nodeHead;
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
