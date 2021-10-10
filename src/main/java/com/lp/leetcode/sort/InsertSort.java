package com.lp.leetcode.sort;

public class InsertSort {

    // 排序后的数组 降序排列
    public void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i];// 临时记录 未排序区间头部元素
            int j = i;// 记录插入的数组下标
            for (; j > 0; j--) {// 从已排序区间末尾开始向前遍历
                if (tmp < nums[j - 1]) {
                    nums[j] = nums[j - 1];
                } else {
                    break;
                }
            }
            nums[j] = tmp;
        }
    }

}
