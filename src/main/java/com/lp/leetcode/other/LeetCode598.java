package com.lp.leetcode.other;

public class LeetCode598 {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) {
            return m * n;
        }
        int a = ops[0][0];
        int b = ops[0][1];
        int length = ops.length;
        for (int i = 1; i < length; i++) {
            a = Math.min(a, ops[i][0]);
            b = Math.min(b, ops[i][1]);
        }
        return a * b;
    }
}
