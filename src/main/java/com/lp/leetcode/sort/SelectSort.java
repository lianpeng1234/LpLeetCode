package com.lp.leetcode.sort;

import java.util.Arrays;

// 核心思想，将选择待排序的数组区分为已排序区间和未排序区间，选择未排序区间中最小的元素，然后插入到已排序区间末尾
public class SelectSort {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        sort(nums);
    }

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            int min = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if(min > nums[j]) {
                    min = nums[j];
                    minIndex = j;
                }
            }

            int tmp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = tmp;
        }

    }

}
