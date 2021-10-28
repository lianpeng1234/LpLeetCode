package com.lp.leetcode.other;

import java.util.LinkedList;

public class LeetCode67 {

    public static void main(String[] args) {
        System.out.println(addBinary("000", "0"));
    }

    public static String addBinary(String a, String b) {
        int al = a.length();
        int bl = b.length();
        int maxL = Math.max(al, bl);

        int carryBit = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= maxL + 1; i++) {
            int x = 0;
            if (i <= al) {
                x = a.charAt(al - i) == 48 ? 0 : 1;
            }
            int y = 0;
            if (i <= bl) {
                y = b.charAt(bl - i) == 48 ? 0 : 1;
            }
            int sum = x + y + carryBit;
            if (sum == 0) {
                list.addFirst(0);
                carryBit = 0;
            } else if (sum == 1) {
                list.addFirst(1);
                carryBit = 0;
            } else if (sum == 2) {
                list.addFirst(0);
                carryBit = 1;
            } else {
                list.addFirst(1);
                carryBit = 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean xx = true;
        for (Integer i : list) {
            if (i == 0) {
                if (xx) {
                    continue;
                }
            }
            xx = false;
            sb.append(i);
        }
        String str= sb.toString();
        if(str.length() == 0) {
            return "0";
        }
        return sb.toString();
    }
}
