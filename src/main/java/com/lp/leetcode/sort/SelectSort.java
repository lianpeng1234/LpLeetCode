package com.lp.leetcode.sort;

import java.util.Arrays;

// 核心思想，将选择待排序的数组区分为已排序区间和未排序区间，选择未排序区间中最小的元素，然后插入到已排序区间末尾
public class SelectSort {

    public static void main(String[] args) {
        int[] a = new int[]{1, 7, 3, 1};
        System.out.println("原始数据:" + Arrays.toString(a));
        int index = -1;// 已排序区间的末尾下标
        int tmp;
        for (int i = 0; i < a.length; i++) {
            int min = a[i];
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {// 获取未排序区间的最小值
                if (min > a[j]) {// 升序排列，稳定排序
                    min = a[j];
                    minIndex = j;
                }
            }
            if (a[index + 1] > a[minIndex]) {// 交换数据
                tmp = a[minIndex];
                a[minIndex] = a[index + 1];
                a[index + 1] = tmp;
            }
            index = i;
            System.out.println("第" + (i + 1) + "步骤:" + Arrays.toString(a));
        }

    }

}
