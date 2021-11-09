package com.lp.leetcode.other;

public class LeetCode704 {
    public int search(int[] nums, int target) {
        int low = 0;
        int height = nums.length - 1;
        while (low < height) {
            int center = (height - low) / 2 + low;
            if (nums[center] == target) {
                return center;
            } else if (target < nums[center]) {
                height = center - 1;
            } else if (nums[center] < target) {
                low = center + 1;
            }
        }
        return -1;
    }
}
