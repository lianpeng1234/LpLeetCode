package com.lp.leetcode.other;

import java.util.Arrays;

public class LeetCode611 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 3, 4};
        System.out.println(triangleNumber(nums));
    }

    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            for (int m = i + 1; m < nums.length; m++) {
                int b = nums[m];
                for (int j = m + 1; j < nums.length; j++) {
                    int c = nums[j];
                    if (check(a, b, c)) {
                        count++;
                    } else {
                        break;
                    }
                }
            }
        }
        return count;
    }

    private static boolean check(int a, int b, int c) {
        if (a + b <= c) {
            return false;
        }
        if (a + c <= b) {
            return false;
        }
        if (b + c <= a) {
            return false;
        }
        return true;
    }


}
