package com.lp.leetcode.search;

// 查找第一个大于等于给定值的元素
public class BranchFind3Variant {
    public static void main(String[] args) {
        int[] a = new int[]{1, 4, 6, 8, 15, 15, 15, 19, 25, 29};

        int index = branchFind(a, 21);
        System.out.println(index);
        System.out.println(a[index]);
    }

    private static int branchFind(int[] a, int value) {
        int low = 0;
        int height = a.length - 1;
        while (low <= height) {
            int center = (height - low) / 2 + low;
            if (a[center] >= value) {
                if (a[center - 1] >= value) {
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
