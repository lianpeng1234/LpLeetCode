package com.lp.leetcode.search;

public class BranchFindEasiest {

    public static void main(String[] args) {
        int[] a = new int[]{1, 4, 6, 8, 10, 15, 19, 25, 29};

        System.out.println(a[5]);

        System.out.println(branchFind(a, 15));

        System.out.println(recursion(a, 0, a.length - 1, 15));
    }

    // 最简单的二分查找，要遍历的数组中不存在重复元素，循环实现
    private static int branchFind(int[] a, int value) {
        int low = 0;
        int height = a.length - 1;
        while (low <= height) {
            int center = (height - low) / 2 + low;
            if (a[center] == value) {
                return center;
            }
            if (value < a[center]) {
                height = center - 1;
            } else {
                low = center + 1;
            }
        }
        return -1;
    }

    // 最简单的二分查找，要遍历的数组中不存在重复元素，递归实现
    private static int recursion(int[] a, int beginIndex, int endIndex, int value) {
        if (beginIndex > endIndex) {
            return -1;
        }
        int center = (endIndex - beginIndex) / 2 + beginIndex;
        if (a[center] == value) {
            return center;
        }
        if (value < a[center]) {
            endIndex = center - 1;
        } else {
            beginIndex = center + 1;
        }
        return recursion(a, beginIndex, endIndex, value);
    }


}
















