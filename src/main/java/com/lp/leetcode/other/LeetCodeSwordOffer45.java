package com.lp.leetcode.other;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCodeSwordOffer45 {

    @Test
    public void test() {
        int[] nums = new int[]{824, 8247};
        minNumber(nums);
    }

    public String minNumber(int[] nums) {
        // 小顶堆
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                String tmp1 = o1 + o2;
                String tmp2 = o2 + o1;
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < nums.length; i++) {
            queue.offer(String.valueOf(nums[i]));
        }

        StringBuilder sb = new StringBuilder();
        while (queue.size() > 0) {
            String str = queue.poll();
            System.out.print(str + "; ");
            sb.append(str);
        }
        return sb.toString();
    }
}
