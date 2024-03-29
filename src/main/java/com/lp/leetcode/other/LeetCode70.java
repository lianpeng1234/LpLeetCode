package com.lp.leetcode.other;

/**
 * 爬楼梯
 */
public class LeetCode70 {
    public int climbStairs(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
