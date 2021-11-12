package com.lp.leetcode.other;

import java.util.regex.Matcher;

public class LeetCode55 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 1, 4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int pos = 0;
        while (pos <= nums.length - 1) {
            int endPos = pos + nums[pos];
            if (endPos >= nums.length - 1) {
                return true;
            }

            int maxDistance = 0;
            for (int i = pos + 1; i <= endPos; i++) {
                int xxx = i + nums[i];
                if (xxx > maxDistance) {
                    pos = i;
                    maxDistance = xxx;
                }
            }

            if (pos >= nums.length - 1) {
                return true;
            }
            if (nums[pos] == 0) {
                return false;
            }
        }
        return false;
    }


}
