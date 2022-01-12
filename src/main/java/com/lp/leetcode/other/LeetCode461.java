package com.lp.leetcode.other;

public class LeetCode461 {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        return Integer.bitCount(z);
    }
}
