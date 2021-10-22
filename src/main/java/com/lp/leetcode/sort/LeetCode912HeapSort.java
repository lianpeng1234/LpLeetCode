package com.lp.leetcode.sort;

import java.util.Arrays;

public class LeetCode912HeapSort {

    public static void main(String[] args) {
        int[] nums = new int[]{-4, 0, 7, 4, 9, -5, -1, 0, -7, -1};
        sortArray(nums);
    }

    public static int[] sortArray(int[] nums) {
        // 从上向下，构建大顶推
//        buildGigHeapFromTopToBottom(nums);

        // 从下向上，构建大顶推
        buildGigHeapFromBottomToTop(nums);

        // 排序
        headSort(nums);

        return nums;
    }

    // 建堆，大顶堆，从上向下
    private static void buildGigHeapFromTopToBottom(int[] nums) {
        int i = nums.length / 2;
        while (i >= 0) {
            fromTopToBottom(nums, nums.length, i);
            i--;
        }
    }

    // 建堆，大顶堆，从下向上
    private static void buildGigHeapFromBottomToTop(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            fromBottomToTop(nums, i);
        }
    }

    // 排序，将大顶堆，堆顶元素与堆尾元素互换，然后从上往下 堆化
    private static void headSort(int[] nums) {
        int endIndex = nums.length - 1;
        while (endIndex > 0) {
            int tmp = nums[endIndex];
            nums[endIndex] = nums[0];
            nums[0] = tmp;

            fromTopToBottom(nums, endIndex, 0);

            endIndex--;
        }
    }

    // 从上向下 堆化，大顶堆
    private static void fromTopToBottom(int[] nums, int length, int k) {
        while (true) {
            int maxPos = k;
            int left = k * 2 + 1;
            int right = k * 2 + 2;
            if (left < length && nums[maxPos] < nums[left]) {
                maxPos = left;
            }
            if (right < length && nums[maxPos] < nums[right]) {
                maxPos = right;
            }

            if (maxPos == k) {
                break;
            }

            int tmp = nums[k];
            nums[k] = nums[maxPos];
            nums[maxPos] = tmp;

            k = maxPos;
        }
    }

    // 从下向上 堆化，大顶堆
    private static void fromBottomToTop(int[] nums, int endIndex) {
        while (endIndex > 0) {
            int father;
            if (endIndex % 2 > 0) {
                father = endIndex / 2;
            } else {
                father = endIndex / 2 - 1;
            }
            if (nums[endIndex] > nums[father]) {
                int tmp = nums[endIndex];
                nums[endIndex] = nums[father];
                nums[father] = tmp;
                endIndex = father;
            } else {
                break;
            }
        }
    }


}
