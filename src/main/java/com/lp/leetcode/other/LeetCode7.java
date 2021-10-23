package com.lp.leetcode.other;

public class LeetCode7 {
    public int reverse(int x) {
        String s = String.valueOf(x);

        s = s.trim();
        Integer.parseInt(s);


        StringBuilder sb = new StringBuilder();
        if (x >= 0) {
            for (int i = s.length() - 1; i > -1; i--) {
                sb.append(s.charAt(i));
            }
        } else {
            sb.append('-');
            for (int i = s.length() - 1; i > 0; i--) {
                sb.append(s.charAt(i));
            }
        }

        long l = Long.parseLong(sb.toString());
        if (l > Integer.MAX_VALUE || l < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) l;
    }
}
