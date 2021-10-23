package com.lp.leetcode.sort;

public class LeetCode912BubbleSort {
    public int[] sortArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean exchange = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    exchange = true;
                }
            }
            if (!exchange) {
                break;
            }
        }
        return nums;
    }


}
