package com.lp.leetcode.other;

import java.util.HashMap;
import java.util.Map;

public class LeetCode415 {
    public String addStrings(String num1, String num2) {
        int length = Math.max(num1.length(), num2.length()) + 1;
        int xxx = 0;
        int length1 = num1.length() - 1;
        int length2 = num2.length() - 1;

        Map<Character, Integer> map = new HashMap<>();
        map.put('0', 0);
        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int a = 0;
            int b = 0;
            if (i <= length1) {
                a = map.get(num1.charAt(length1 - i));
            }
            if (i <= length2) {
                b = map.get(num2.charAt(length2 - i));
            }

            int sum = a + b + xxx;
            if (sum > 9) {
                xxx = 1;
                sb.insert(0, sum % 10);
            } else {
                xxx = 0;
                sb.insert(0, sum);
            }
        }
        String str = sb.toString();
        if(str.startsWith("0")) {
            return str.substring(1, str.length());
        }

        return str;

    }
}
