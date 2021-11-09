package com.lp.leetcode.other;

import java.util.Arrays;

public class LeetCode31 {
    public void nextPermutation(int[] nums) {
        int xx = nums.length - 1;
        boolean isSwap = false;
        for (int i = xx; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                isSwap =
            }
        }
        if (!isSwap) {
            Arrays.sort(nums);
        }
    }
}
