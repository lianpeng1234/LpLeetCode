package com.lp.leetcode.heap;

import java.util.*;

public class LeetCode347 {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, -1, 2, -1, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i : nums) {
            int count = map.getOrDefault(i, 0);
            count++;
            map.put(i, count);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//                if (o1.getValue() > o1.getValue()) {
//                    return 1;
//                } else if (o1.getValue().intValue() == o2.getValue()) {
//                    return 0;
//                } else {
//                    return 1;
//                }
                return o1.getValue() - o2.getValue();
            }
        });

        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            queue.offer(item);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[] xx = new int[k];
        for (int i = 0; i < k; i++) {
            xx[i] = queue.poll().getKey();
        }
        return xx;
    }
}
