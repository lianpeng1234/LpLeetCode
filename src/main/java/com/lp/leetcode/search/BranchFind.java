package com.lp.leetcode.search;

// 二分查找，数组中存在的元素
public class BranchFind {

    public static void main(String[] args) {
        int target = 6;

        int[] a = new int[]{1, 4, 6, 8, 10, 15, 19, 25, 29};

        int index = -1;

//        index = find(target, a);
//        index = findFirstEqual(target, a);
//        index = findLastEqual(target, a);
//        index = findFirstGreatThanOrEqual(target, a);
        index = findLastLessThanOrEqual(target, a);

        if (index < 0) {
            System.out.println("target=" + target + "; index=" + index);
        } else {
            System.out.println("target=" + target + "; index=" + index + "; " + a[index]);
        }
    }

    // 二分查找，数组中存在的元素
    private static int find(int target, int[] a) {
        int begin = 0;
        int end = a.length - 1;
        while (begin <= end) {
            int center = (begin + end) / 2;
            if (a[center] < target) {
                begin = center + 1;
            } else if (target < a[center]) {
                end = center - 1;
            } else if (a[center] == target) {
                return center;
            }
        }
        return -1;
    }

    // 查找第一个等于指定元素的下标
    private static int findFirstEqual(int target, int[] a) {
        int begin = 0;
        int end = a.length;
        while (begin <= end) {
            int center = (begin + end) / 2;
            if (a[center] < target) {
                begin = center + 1;
            } else if (target < a[center]) {
                end = center - 1;
            } else {
                if (center == 0 || a[center - 1] != target) {
                    return center;
                }
            }
        }
        return -1;
    }

    // 查找最后一个等于指定元素的下标
    private static int findLastEqual(int target, int[] a) {
        int begin = 0;
        int end = a.length;
        while (begin <= end) {
            int center = (begin + end) / 2;
            if (a[center] < target) {
                begin = center + 1;
            } else if (target < a[center]) {
                end = center - 1;
            } else {
                if (center == a.length - 1 || a[center + 1] != target) {
                    return center;
                }
            }
        }
        return -1;
    }

    // 查找第一个大于等于指定元素的下标
    private static int findFirstGreatThanOrEqual (int target, int[] a) {
        int begin = 0;
        int end = a.length;
        while (begin <= end) {
            int center = (begin + end) / 2;
            if (a[center] < target) {
                begin = center + 1;
            } else if (target <= a[center]) {
                if (center == 0 || a[center - 1] < target) {
                    return center;
                } else {
                    end = center - 1;
                }
            }
        }
        return -1;
    }

    // 查找最后一个小于等于指定元素的下标
    private static int findLastLessThanOrEqual(int target, int[] a) {
        int begin = 0;
        int end = a.length;
        while (begin <= end) {
            int center = (begin + end) / 2;
            if (a[center] <= target) {
                if (center == a.length - 1 || a[center + 1] > target) {
                    return center;
                } else {
                    begin = center + 1;
                }
            } else if (a[center] > target) {
                end = center - 1;
            }
        }
        return -1;
    }


}
