package com.lp.leetcode.other;

import java.util.*;

public class LeetCode881 {

    public int numRescueBoats(int[] people, int limit) {
        // 排序
        Arrays.sort(people);
        int countShip = 0;
        for (int i = 0; i < people.length; i++) {
            if (people[i] == Integer.MAX_VALUE) {
                continue;
            }
            int xx = limit - people[i];
            int index = binarySearch(people, i + 1, people.length - 1, xx);
            if (index == -1) {
                countShip++;
                continue;
            }
            people[index] = Integer.MAX_VALUE;
            countShip++;
        }
        return countShip;
    }

    // 二分查找最后一个小于等于的的元素
    private int binarySearch(int[] people, int begin, int end, int target) {
        int low = begin;
        int height = end;
        while (low <= height) {
            int center = (height - low) / 2 + low;
            if (people[center] <= target) {
                if (center < people.length - 1 && people[center + 1] <= target) {
                    low = center + 1;
                } else {
                    return center;
                }
            } else {
                height = center - 1;
            }
        }
        return -1;
    }


}
