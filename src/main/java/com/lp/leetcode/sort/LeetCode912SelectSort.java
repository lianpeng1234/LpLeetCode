package com.lp.leetcode.sort;

public class LeetCode912SelectSort {
    public int[] sortArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minPos = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[minPos] > nums[j]) {
                    minPos = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[minPos];
            nums[minPos] = tmp;
        }
        return nums;
    }


}
