package com.lp.leetcode.sort;

import java.util.Arrays;

// 核心思想，利用递归的编程技巧，将数组进行拆分，然后对拆分后的数组进行排序合并。
public class MergeSortX {

    public static void main(String[] args) {
        int[] a = new int[]{6, 8, 7, 6, 3, 5, 9, 4};//3, 2, 7, 5, 4, 1
        System.out.println(Arrays.toString(split(a, 0, a.length - 1)));
    }

    public static int[] split(int[] array, int begin, int end) {
        int length = end - begin + 1;
        if (length == 1) {
            int[] tmpArray = new int[length];
            tmpArray[0] = array[end];
            return tmpArray;
        }
        if (length == 2) {
            int[] tmpArray = new int[length];
            // 排序，对数据排序
            if (array[begin] > array[end]) { // 降序
                tmpArray[0] = array[end];
                tmpArray[1] = array[begin];
            } else {
                tmpArray[0] = array[begin];
                tmpArray[1] = array[end];
            }
            return tmpArray;
        }

        int center = length / 2;
        int[] array1 = split(array, begin, begin + center);
        int[] array2 = split(array, begin + center + 1, end);
        return merge(array1, array2);
    }

    public static int[] merge(int[] array1, int[] array2) {
        int[] tmpArray = new int[array1.length + array2.length];
        int array1Index = 0;
        int array2Index = 0;
        for (int i = 0; i < tmpArray.length; i++) {
            if (array1Index >= array1.length) {
                tmpArray[i] = array2[array2Index];
                array2Index++;
            } else if (array2Index >= array2.length) {
                tmpArray[i] = array1[array1Index];
                array1Index++;
            } else if (array1[array1Index] < array2[array2Index]) {
                tmpArray[i] = array1[array1Index];
                array1Index++;
            } else {
                tmpArray[i] = array2[array2Index];
                array2Index++;
            }
        }
        return tmpArray;
    }

}
