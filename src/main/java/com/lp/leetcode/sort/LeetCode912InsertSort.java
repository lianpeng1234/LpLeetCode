package com.lp.leetcode.sort;

public class LeetCode912InsertSort {
    public int[] sortArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i];
            int j = i;
            for (; j > 0; j--) {
                if (tmp < nums[j - 1]) {
                    nums[j] = nums[j - 1];
                } else {
                    break;
                }
            }
            nums[j] = tmp;
        }
        return nums;
    }


}
