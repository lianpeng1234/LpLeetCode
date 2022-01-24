package com.lp.leetcode.other;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCodeSwordOffer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] f = new int[queue.size()];
        int count = 0;
        while (queue.size() > 0) {
            f[count] = queue.poll();
            count++;
        }
        return f;
    }
}
