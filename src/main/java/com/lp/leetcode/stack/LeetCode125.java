package com.lp.leetcode.stack;

/**
 * 验证回文串
 */
public class LeetCode125 {

    public static void main(String[] args) {
        String s = "abccb,a";
        isPalindrome(s);
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int begin = 0;
        int end = s.length() - 1;
        while (true) {
            if (begin >= end) {
                return true;
            }

            while (true) {
                // 如果 begin index 已经超过了 字符串长度，说明字符串中没有符合要求的 字母字符和数字字符
                if (begin >= s.length()) {
                    return true;
                }
                // 过滤掉字符串中，除 字母、数字 以外的任意字符
                if (96 < s.charAt(begin) && s.charAt(begin) < 123) {
                    break;
                } else if (47 < s.charAt(begin) && s.charAt(begin) < 58) {
                    break;
                } else {
                    begin++;
                }
            }

            while (true) {
                // 过滤掉字符串中，除 字母、数字 以外的任意字符
                if (96 < s.charAt(end) && s.charAt(end) < 123) {
                    break;
                } else if (47 < s.charAt(end) && s.charAt(end) < 58) {
                    break;
                } else {
                    end--;
                }
            }

            // 不相等说明，不是回文字符串
            if (s.charAt(begin) != s.charAt(end)) {
                return false;
            }
            begin++;
            end--;
        }
    }


}



