package com.lp.leetcode.other;

import java.util.Comparator;
import java.util.PriorityQueue;

// 大顶堆排序，依次去堆顶元素
public class LeetCode179 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 30, 34, 5, 9};
        largestNumber(nums);
    }

    public static String largestNumber(int[] nums) {

        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) {
                    StringBuilder sb = new StringBuilder(o1);
                    for (int i = 0; i < o2.length() - o1.length(); i++) {
                        sb.append(o1.charAt(o1.length() - 1));
                    }
                    o1 = sb.toString();
                }
                if (o1.length() > o2.length()) {
                    StringBuilder sb = new StringBuilder(o2);
                    for (int i = 0; i < o1.length() - o2.length(); i++) {
                        sb.append(o2.charAt(o2.length() - 1));
                    }
                    o2 = sb.toString();
                }

                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < nums.length; i++) {
            queue.offer(String.valueOf(nums[i]));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(queue.poll());
        }

        return sb.toString();
    }
}
