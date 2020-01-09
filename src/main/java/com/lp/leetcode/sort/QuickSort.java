package com.lp.leetcode.sort;

import java.util.Arrays;

// 核心思想，选取数组的最后一个元素作为基准元素，循环与其他数组其它元素进行比较，如果符合条件（例如：小于基准元素的在基准元素的左边，大于的在右边）就交换位置
public class QuickSort {

    public static void main(String[] args) {
        int[] a = new int[]{100, 5, 8, 23, 67, 14, 23};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    private static void quickSort(int[] a, int begin, int end) {



    }


}
