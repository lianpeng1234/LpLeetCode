package com.lp.leetcode.other;

public class LeetCode647 {
    public int countSubstrings(String s) {
        int count = 0;
        int length = s.length();
        boolean[][] dp = new boolean[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) {
                    dp[j][i] = true;
                    count++;
                } else if (i - j == 1 && s.charAt(j) == s.charAt(i)) {
                    dp[j][i] = true;
                    count++;
                } else if (s.charAt(j) == s.charAt(i) && dp[j + 1][i - 1]) {
                    dp[j][i] = true;
                    count++;
                }
            }
        }

        return count;
    }
}
