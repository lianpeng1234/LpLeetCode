package com.lp.leetcode.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {
        int[] A = new int[]{3, 8, 5, 2};
        System.out.println("排序后 " + Arrays.toString(sort(A)));
    }

    public static int[] sort(int[] A) {
        // 寻找最大值，最小值
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (min > A[i]) {
                min = A[i];
            }
            if (max < A[i]) {
                max = A[i];
            }
        }

        System.out.println("取值范围 " + min + "--" + max);

        // 创建数组 B
        int lengthB = max - min + 1;
        int[] B = new int[lengthB];

        // 遍历数组 A，将对应的相同元素出现的次数记录到数组 B 中
        for (int i = 0; i < A.length; i++) {
            B[A[i] - min] = B[A[i] - min] + 1;
        }
        System.out.println("数组B " + Arrays.toString(B));

        // 对数组 B 进行顺序求和
        for (int i = 1; i < B.length; i++) {
            B[i] = B[i - 1] + B[i];
        }
        System.out.println("数组B顺序求和 " + Arrays.toString(B));

        // 创建数组 C
        int[] C = new int[A.length];

        //
        for (int i = 0; i < A.length; i++) {
            int X = A[i];
            int posstion = B[X - min] - 1;
            C[posstion] = X;
            B[X - min] = posstion;
        }

        return C;
    }


}
