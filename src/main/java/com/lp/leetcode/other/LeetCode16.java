package com.lp.leetcode.other;

import java.util.Arrays;

public class LeetCode16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int distance = 0;
        int sum = 0;
        for (int k = 0; k < nums.length - 1; k++) {
            int l = k + 1;
            int r = nums.length - 1;
            while (true) {
                if (l >= r) {
                    break;
                }
                int tmpSum = nums[k] + nums[l] + nums[r] - target;
                if (tmpSum == target) {
                    return target;
                } else if (tmpSum < target) {
                    int xx = Math.abs(tmpSum);
                    if (xx < distance) {
                        distance = xx;
                        sum = tmpSum;
                    }
                    l++;
                } else if (tmpSum > target) {
                    int xx = Math.abs(tmpSum);
                    if (xx < distance) {
                        distance = xx;
                        sum = tmpSum;
                    }
                    r--;
                }
            }
        }

        return sum;
    }
}
