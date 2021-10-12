package com.lp.leetcode.sort;

import java.util.Arrays;

// 核心思想，选取数组的最后一个元素作为基准元素，循环与其他数组其它元素进行比较，如果符合条件（例如：小于基准元素的在基准元素的左边，大于的在右边）就交换位置
public class QuickSort {

    public static void main(String[] args) {
        int[] a = new int[]{6, 11, 9, 3, 4, 8};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    private static void quickSort(int[] a, int beginIndex, int endIndex) {
        if (beginIndex >= endIndex) {// 递归 退出条件
            return;
        }
        int i = beginIndex;
        int pivot = a[endIndex];
        for (int j = beginIndex; j < endIndex; j++) {
            if (a[j] < pivot) {// 降序排列
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;
            }
        }
        a[endIndex] = a[i];
        a[i] = pivot;

        quickSort(a, beginIndex, i - 1);
        quickSort(a, i + 1, endIndex);
    }

    // 两个变量 i，j 两个变量均指向数组的头部
    // j 用于遍历数组寻找比 pivot 小的元素，
    // 如果 a[j] < pivot，则 a[i] 与 a[j] 指向的数组元素进行交换并且 i++、j++，反之 i 不动，j++
    // 重复步骤 2，


}
