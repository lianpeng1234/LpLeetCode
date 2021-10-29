package com.lp.leetcode.other;

import java.util.Arrays;

public class LeetCode455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        for (int i = 0; i < g.length; i++) {
            int eat = g[i];

            int index = branchFind(s, eat);
            if (index > -1) {
                count++;
                s[index] = -1;
            }
        }

        return count;
    }

    private static int branchFind(int[] a, int value) {
        int low = 0;
        int height = a.length - 1;
        while (low <= height) {
            int center = (height - low) / 2 + low;
            if (a[center] >= value) {
                if (center >= 1 && a[center - 1] >= value) {
                    height = center - 1;
                } else {
                    return center;
                }
            } else {
                low = center + 1;
            }
        }
        return -1;
    }

}
