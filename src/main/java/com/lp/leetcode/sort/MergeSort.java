package com.lp.leetcode.sort;

import java.util.Arrays;

// 核心思想，利用递归的编程技巧，将数组进行拆分，然后对拆分后的数组进行排序合并。
public class MergeSort {

    public static void main(String[] args) {
        int[] a = new int[]{6,8,7,6,3,5,9,4};//3, 2, 7, 5, 4, 1
        int[] c = split(a, 0, a.length - 1);


        System.out.println(Arrays.toString(c));
    }

    private static int[] split(int a[], int begin, int end) {// 拆分数组
        if (begin == end) {
            return new int[]{a[begin]};
        }

        int center = (begin + end) / 2;
        int[] mA = split(a, begin, center);
        int[] mB = split(a, center + 1, end);
        return merge(mA, mB);
    }

    private static int[] merge(int a[], int b[]) {// 将两个数组合并
        int n = a.length + b.length;
        int[] c = new int[n];
        int aIndex = 0;
        int bIndex = 0;
        for (int i = 0; i < n; i++) {
            if (aIndex >= a.length) {// 如果条件成立，说明数组 a 已经全部放到数组 c 中，只需样数组 b 中剩余元素放入数组 c 中
                if (bIndex < b.length) {// 防止出现数组下标越界的问题
                    c[i] = b[bIndex];
                    bIndex++;
                }
                continue;
            }

            if (bIndex >= b.length) {// 如果条件成立，说明数组 b 已经全部放到数组 c 中，只需样数组 a 中剩余元素放入数组 c 中
                if (aIndex < a.length) {// 防止出现数组下标越界的问题
                    c[i] = a[aIndex];
                    aIndex++;
                }
                continue;
            }

            if (a[aIndex] <= b[bIndex]) {// 去掉 “=” 就不是稳定排序了
                c[i] = a[aIndex];
                aIndex++;
            } else {
                c[i] = b[bIndex];
                bIndex++;
            }
        }
        return c;
    }


}
