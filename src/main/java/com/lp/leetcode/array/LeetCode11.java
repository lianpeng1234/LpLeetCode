package com.lp.leetcode.array;

/**
 * 题目编号 11
 * 盛最多水的容器
 */
public class LeetCode11 {

    public static void main(String[] args) {
        int[] height = new int[]{2, 3, 4, 5, 18, 17, 6};
        int lp = area(height);
        System.out.println(lp);
    }

    public static int area(int[] height) {
        int length = height.length;
        int beforeIndex = 0;
        int afterIndex = length - 1;
        int min = 0;
        int tmp = 0;
        boolean isBefore;

        int s = 0;
        do {
            if (height[beforeIndex] <= height[afterIndex]) {
                min = height[beforeIndex];
                isBefore = true;
            } else {
                min = height[afterIndex];
                isBefore = false;
            }

            tmp = min * (afterIndex - beforeIndex);
            if (s < tmp) {
                s = tmp;
            }

            if (isBefore) {
                beforeIndex++;
            } else {
                afterIndex--;
            }

        } while (beforeIndex != afterIndex);

        return s;
    }

}
