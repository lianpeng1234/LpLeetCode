package com.lp.leetcode.other;

import java.util.ArrayList;
import java.util.List;

public class LeetCode46 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        int[] selectedIndex = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            selectedIndex[0] = i;
            xx(nums, selectedIndex, 1, result);
        }
        return result;
    }

    private static void xx(int[] nums, int[] selectedIndex, int selectedCount, List<List<Integer>> result) {
        if (selectedCount >= nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int s = 0; s < selectedIndex.length; s++) {
                list.add(nums[selectedIndex[s]]);
            }
            result.add(list);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            boolean flat = true;
            for (int s = 0; s < selectedCount; s++) {
                if (i == selectedIndex[s]) {
                    flat = false;
                    break;
                }
            }
            if (flat) {
                selectedIndex[selectedCount] = i;
                xx(nums, selectedIndex, selectedCount + 1, result);
            }
        }
    }

}
