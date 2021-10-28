package com.lp.leetcode.other;

import java.util.Comparator;
import java.util.PriorityQueue;

// 大顶堆排序，依次去堆顶元素
public class LeetCode179 {

    public static void main(String[] args) {
        int[] nums = new int[]{34323, 3432};
        largestNumber(nums);
    }

    public static String largestNumber(int[] nums) {

        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o2.compareTo(o1);
                }
                String tmp1 = o1 + o2;
                String tmp2 = o2 + o1;
                return tmp2.compareTo(tmp1);
            }
        });

        for (int i = 0; i < nums.length; i++) {
            queue.offer(String.valueOf(nums[i]));
        }

        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            String str = queue.poll();
            if ("0".equals(str) && flag) {
                continue;
            }
            flag = false;
            sb.append(str);
            System.out.println(str);
        }

        if(sb.toString().length() < 1) {
            return "0";
        }
        return sb.toString();
    }
}
