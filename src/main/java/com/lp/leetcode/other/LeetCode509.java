package com.lp.leetcode.other;

public class LeetCode509 {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int beforeBefore = 0;// f(0)
        int before = 1;// f(1)
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = before + beforeBefore;

            beforeBefore = before;
            before = result;
        }
        return result;
    }
}
