package com.lp.leetcode.other;

public class LeetCode367 {
    public boolean isPerfectSquare(int num) {
        long count = 1;
        while (true) {
            long xx = count * count;
            if (xx == num) {
                return true;
            } else if (xx >= num) {
                return false;
            } else {
                count++;
            }
        }
    }
}
