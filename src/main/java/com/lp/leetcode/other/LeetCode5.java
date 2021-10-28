package com.lp.leetcode.other;

import java.util.HashMap;

public class LeetCode5 {

    public String longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int startPos = 0;
        int endPos = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int tmp = map.getOrDefault(c, -1);
            if (tmp == -1) {
                map.put(c, i);
                continue;
            }

            int xx = i - tmp;
            if (xx % 2 == 0 || xx % 2 == 1) {
                int aa = i - tmp + 1;
                if (aa > maxLength) {
                    maxLength = aa;
                    startPos = tmp;
                    endPos = i;
                }
            }
            map.put(c, i);
        }

        return s.substring(startPos, endPos + 1);
    }


}
