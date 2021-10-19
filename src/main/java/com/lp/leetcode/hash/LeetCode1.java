package com.lp.leetcode.hash;

import java.util.HashMap;

public class LeetCode1 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        int tmp;
        for (int i = 0; i < length; i++) {
            tmp = target - nums[i];
            if (map.containsKey(tmp)) {
                return new int[]{map.get(tmp), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }


}
