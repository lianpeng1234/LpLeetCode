package com.lp.leetcode.array;

import java.util.Arrays;

public class LeetCode88 {

    public static void main(String[] args) {

    }

    public static void mergex(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[nums1.length];
        int one = 0;
        int two = 0;
        for (int i = 0; i < tmp.length; i++) {
            if (one >= m) {
                tmp[i] = nums2[two];
                two++;
                continue;
            }
            if (two >= n) {
                tmp[i] = nums1[one];
                one++;
                continue;
            }

            if (nums1[one] <= nums2[two]) {
                tmp[i] = nums1[one];
                one++;
            } else {
                tmp[i] = nums2[two];
                two++;
            }
        }

        for (int i = 0; i < tmp.length; i++) {
            nums1[i] = tmp[i];
        }

    }

}
