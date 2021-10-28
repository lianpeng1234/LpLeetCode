package com.lp.leetcode.other;

public class LeetCode14 {

    public String longestCommonPrefix(String[] strs) {
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minLength) {
                minLength = strs[i].length();
            }
        }

        int x = xxx(strs, minLength);
        return strs[0].substring(0,x);
    }


    private int xxx(String[] strs, int minLength) {
        int i = 0;
        for (; i < minLength; i++) {
            for (int j = 0; j <= strs.length - 2; j++) {
                if (strs[j].charAt(i) != strs[j + 1].charAt(i)) {
                    return i;
                }
            }
        }
        return i;
    }

}
