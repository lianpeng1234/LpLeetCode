package com.lp.leetcode.sort;

public class BubbleSort {

    // 传统的冒泡排序
    public void bubbleSort1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                }
            }
        }
    }

    // 优化后的冒泡排序
    public int bubbleSort2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean exchange = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                    exchange = true;
                }
            }
            if (!exchange) {
                break;
            }
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }


}
