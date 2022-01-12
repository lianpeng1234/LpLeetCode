package com.lp.leetcode.other;

public class LeetCode494 {

    public int Times;

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int target = 2;

        LeetCode494 leetCode494 = new LeetCode494();
        System.out.println(leetCode494.findTargetSumWays(nums, target));
        System.out.println(leetCode494.Times);

    }

    private int count;

    public int findTargetSumWays(int[] nums, int target) {
        diGui(nums, target, 0, 0);
        return count;
    }

    private void diGui(int[] nums, int target, int index, int sum) {
        Times++;
        if (index >= nums.length) {
            if (sum == target) {
                count++;
            }
            return;
        }

        diGui(nums, target, index + 1, sum + nums[index]);

        diGui(nums, target, index + 1, sum - nums[index]);
    }
}
