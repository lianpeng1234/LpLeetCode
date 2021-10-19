package com.lp.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

public class LeetCode953 {

    public static void main(String[] args) {
        String[] words = new String[]{"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        isAlienSorted(words, order);
    }

    public static boolean isAlienSorted(String[] words, String order) {
        Map<Integer, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put((int) order.charAt(i), i);
        }

        for (int i = 0; i < words.length; i++) {
            if (i + 1 >= words.length) {
                break;
            }
            boolean b = isSwap(words[i], words[i + 1], orderMap);
            if (!b) {
                return false;
            }

        }

        return true;
    }

    private static boolean isSwap(String str1, String str2, Map<Integer, Integer> orderMap) {
        int l1 = str1.length();
        int l2 = str2.length();
        int times = Math.min(l1, l2);
        for (int i = 0; i < times; i++) {
            char c1 = str1.charAt(i);
            int index1 = orderMap.get((int) c1);

            char c2 = str2.charAt(i);
            int index2 = orderMap.get((int) c2);
            if (index1 < index2) {
                return true;
            } else if (index1 == index2) {
                continue;
            } else {
                return false;
            }
        }

        if (l1 > l2) {
            return false;
        }

        return true;
    }

}
