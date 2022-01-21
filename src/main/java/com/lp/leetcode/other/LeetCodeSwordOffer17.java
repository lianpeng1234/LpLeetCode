package com.lp.leetcode.other;

import java.util.Arrays;

public class LeetCodeSwordOffer17 {

    public static void main(String[] args) {
        LeetCodeSwordOffer17 lc = new LeetCodeSwordOffer17();
        int[] a = lc.printNumbers(3);
        System.out.println(Arrays.toString(a));
    }

    public int[] printNumbers(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(9);
        }
        int a = Integer.parseInt(sb.toString());
        int[] b = new int[a];
        for (int i = 1; i <= a; i++) {
            b[i - 1] = i;
        }
        return b;
    }

}
