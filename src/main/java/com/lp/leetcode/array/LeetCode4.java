package com.lp.leetcode.array;

/**
 * 题目编号 4
 * 寻找两个正序数组的中位数
 */
@Deprecated
public class LeetCode4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] tmp = merge(nums1, nums2);

        int a = tmp.length % 2;
        int center;
        if (a == 0) {
            center = tmp.length / 2;
            double d = (double) (tmp[center] + tmp[center - 1]);
            return d / 2;
        } else {
            center = tmp.length / 2;
            return tmp[center];
        }
    }

    private static int[] merge(int[] nums1, int[] nums2) {
        int[] tmp = new int[nums1.length + nums2.length];
        int m = nums1.length;
        int n = nums2.length;
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

        return tmp;
    }

}
