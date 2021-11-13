package com.lp.leetcode.other;

public class LeetCode520 {
    public boolean detectCapitalUse(String word) {
        // asc 码 A-Z 65-90, a-z  97-122

        // 首字符是否大写
        boolean firstUpper = false;
        if (word.charAt(0) <= 90) {
            firstUpper = true;
        }

        int countUpper = 0;
        int countLower = 0;
        if (firstUpper) {
            countUpper++;
        } else {
            countLower++;
        }

        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) >= 97) {// 小写
                countLower++;
            } else {
                countUpper++;
            }
        }

        if (countLower == word.length()) {
            return true;
        }
        if (countUpper == word.length()) {
            return true;
        }
        if (firstUpper && countUpper == 1 && countLower == word.length() - 1) {
            return true;
        }
        return false;
    }
}
