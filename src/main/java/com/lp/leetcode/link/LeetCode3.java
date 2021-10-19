package com.lp.leetcode.link;

import java.util.HashMap;

public class LeetCode3 {

    public static void main(String[] args) {
        String s = "dvdf";
        int length = lengthOfLongestSubstring(s);
        System.out.println(length);
    }

    // 时间复杂度 O(n)，空间复杂度 O(n)
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(map.get(c), start);
            }
            maxLength = Math.max(maxLength, end - start + 1);
            map.put(c, end + 1);
        }
        return maxLength;
    }

}
