package com.lp.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长回文串
 */
public class LeetCode409 {
    public int longestPalindrome(String s) {
        int maxLength = 0;
        int ji = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer count = map.getOrDefault(s.charAt(i), 0);
            count++;
            map.put(s.charAt(i), count);
        }

        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            int count = characterIntegerEntry.getValue();
            if (count % 2 == 0) {
                maxLength = maxLength + count;
            } else {
                maxLength = maxLength + count - 1;
                if (ji == 0) {
                    ji++;
                }
            }
        }

        return maxLength + ji;
    }
}
