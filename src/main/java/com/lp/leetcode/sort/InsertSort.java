package com.lp.leetcode.sort;

public class InsertSort {

    // 代码中演示的排序为 降序（从小到大）
    public void sort(int[] nums) {
        int orderlyEndIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[orderlyEndIndex] > nums[i]) {// 已排序区间 最后一个元素 比 未排序区间的 第一个元素大
                for (int j = i; j > 0; j--) {// 从已排序区间末尾开始向前遍历
                    if (nums[j] < nums[j - 1]) { // 遍历到的元素如果比 X 大则交换位置
                        int tmp = nums[j];
                        nums[j] = nums[j-1];
                        nums[j-1] = tmp;
                    }
                }
            }
            orderlyEndIndex = i;// 已排序区间的末尾临界数组下标完后移动到 i
        }
    }


}
