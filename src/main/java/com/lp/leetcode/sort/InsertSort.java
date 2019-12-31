package com.lp.leetcode.sort;

import java.util.Arrays;

// 核心思想，将选择待排序的数组区分为已排序区间和未排序区间，选择未排序区间的第一个元素，在已排序区间找到合适的位置并插入
public class InsertSort {

    public static void main(String[] args) {
        int[] a = new int[]{6, 3, 4, 3};
        System.out.println("原始数据：" + Arrays.toString(a));

        int index = 0;// 已经排序区间的末尾下标
        int tmp;
        for (int i = 1; i < a.length; i++) {
            if (a[index] > a[i]) {//  升序排列
                for (int j = i; j > 0; j--) {
                    if (a[j] < a[j - 1]) {//  升序排列，并保证是稳定排序
                        // 交换数据
                        tmp = a[j];
                        a[j] = a[j - 1];
                        a[j - 1] = tmp;
                    }
                }
            }
            System.out.println("第" + i + "步：   " + Arrays.toString(a));
            index = i;
        }


    }

}
