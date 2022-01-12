package com.lp.leetcode.other;

import java.util.Arrays;

public class LeetCode31 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 2, 10, 9, 3, 2, 1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    // 3 2 1
    public static void nextPermutation(int[] nums) {
        int x = -1;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i - 1] < nums[i]) {
                x = i - 1;
                break;
            }
        }

        if (x > -1) {
            int y = -1;
            for (int i = nums.length - 1; i > x; i--) {
                if (nums[i] > nums[x]) {
                    y = i;
                    break;
                }
            }
            int tmp = nums[x];
            nums[x] = nums[y];
            nums[y] = tmp;
        }
        Arrays.sort(nums, x + 1, nums.length);
    }

}
