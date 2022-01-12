package com.lp.leetcode.other;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LeetCode239 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;// 大顶堆
            }
        });

        HashMap<Integer, Integer> mapIndex = new HashMap();
        for (int i = 0; i < k - 1; i++) {
            heap.offer(nums[i]);
            mapIndex.put(nums[i], i);
        }

        int[] result = new int[nums.length - k + 1];
        int resultIndex = 0;

        for (int i = k - 1; i < nums.length; i++) {
            mapIndex.put(nums[i], i);
            heap.offer(nums[i]);
            int windowBeginIndex = i - k + 1;
            int windowEndIndex = windowBeginIndex + k - 1;

            while (true) {
                if (heap.size() <= 0) {
                    break;
                }
                int heapMax = heap.poll();
                int heapMaxIndex = mapIndex.get(heapMax);
                if (windowBeginIndex <= heapMaxIndex && heapMaxIndex <= windowEndIndex) {
                    result[resultIndex] = heapMax;
                    resultIndex++;

                    if (windowBeginIndex < heapMaxIndex) {
                        heap.offer(heapMax);
                    }

                    break;
                }
            }
        }

        return result;
    }
}
