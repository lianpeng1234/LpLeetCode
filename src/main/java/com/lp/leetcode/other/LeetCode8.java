package com.lp.leetcode.other;

public class LeetCode8 {
    public int myAtoi(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == 0 && c == 45) {
                sb.append('-');
                continue;
            }
            if (i == 0 && c == 43) {
                sb.append('+');
                continue;
            }

            if (c >= 48 && c <= 57) {
                sb.append(c);
                continue;
            }

            break;
        }

        String xx = sb.toString();

        if (xx.length() > 0) {
            if (xx.length() == 1) {
                if (xx.charAt(0) == 45 || xx.charAt(0) == 43) {
                    return 0;
                }
            }
            if (xx.length() >= 15 && xx.charAt(0) == 45) {
                return Integer.MIN_VALUE;
            }
            if (xx.length() >= 15) {
                return Integer.MAX_VALUE;
            }
            long l = Long.parseLong(sb.toString());
            if (l > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (l < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            return (int) l;
        }
        return 0;
    }
}
