package com.lp.leetcode.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode15 {

    public static void main(String[] args) {
        // -4 -1 -1 0 1 2
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();
        for (int k = 0; k < nums.length - 1; k++) {
            if (nums[k] > 0) {
                break;
            }
            if (k > 0 && nums[k] == nums[k - 1]) {// 去重
                continue;
            }

            int begin = k + 1;
            int end = nums.length - 1;
            while (begin < end) {
                int sum = nums[k] + nums[begin] + nums[end];
                if (sum < 0) {
                    begin++;
                } else if (sum == 0) {
                    List<Integer> sun = new ArrayList<>();
                    sun.add(nums[k]);
                    sun.add(nums[begin]);
                    sun.add(nums[end]);
                    list.add(sun);

                    while (true) {// 去重
                        begin++;
                        if (nums[begin - 1] != nums[begin] || begin >= end) {
                            break;
                        }
                    }
                    while (true) {// 去重
                        end--;
                        if (nums[end + 1] != nums[end] || begin >= end) {
                            break;
                        }
                    }
                } else {
                    end--;
                }
            }
        }
        return list;
    }

}
