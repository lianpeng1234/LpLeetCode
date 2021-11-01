package com.lp.leetcode.other;

import java.util.Arrays;
import java.util.HashMap;

public class LeetCode260 {
    public int[] singleNumber(int[] nums) {
        int[] a = new int[2];
        int aIndex = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0);
            count++;
            map.put(nums[i], count);
        }

        for (int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) == 1) {
                a[aIndex] = nums[i];
                aIndex++;
            }
        }

        return a;
    }

}
