package com.lp.leetcode.other;

import java.util.regex.Matcher;

public class LeetCode55 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 0};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        return canJump(nums, 0);
    }

    private static boolean canJump(int[] nums, int pos) {
        while (true) {
            if (pos >= nums.length - 1) {
                return true;
            }
            if (nums[pos] == 0) {
                return false;
            }
            int end = Math.min(nums.length - 1, nums[pos] + pos);
            for (int j = end; j >= pos + 1 && j < nums.length; j--) {
                boolean can = canJump(nums, j);
                if (can) {
                    return true;
                }
            }
            return false;
        }
    }

}
