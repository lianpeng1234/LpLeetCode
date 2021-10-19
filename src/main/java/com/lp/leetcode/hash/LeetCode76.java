package com.lp.leetcode.hash;

import java.util.HashMap;

public class LeetCode76 {

    public static void main(String[] args) {
        String s = "bdab";
        String t = "ab";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        HashMap<Integer, Integer> map = getMap(t);
        int minLength = 0;
        int start = 0;
        int end = Integer.MAX_VALUE;
        int windowStart = 0;
        int windowEnd = -1;
        boolean moveEnd = true;

        while (true) {
            if (windowEnd >= s.length()) {
                break;
            }
            int key;
            if (moveEnd) {
                windowEnd++;
                key = s.charAt(windowEnd);
            } else {
                key = s.charAt(windowStart);
                windowStart++;
            }
            if (moveEnd) {
                if (map.containsKey(key)) {
                    int count = map.get(key) - 1;
                    if (count == 0) {
                        map.remove(key);
                    } else {
                        map.put(key, count);
                    }
                }
                if (map.isEmpty()) {
                    if (windowEnd - windowStart < end - start) {
                        start = windowStart;
                        end = windowEnd;
                    }
                    moveEnd = false;
                    map = getMap(t);
                }
            } else {
                if (map.containsKey(key)) {
                    moveEnd = true;
                } else {
                    continue;
                }
            }

        }


    }

    private static HashMap<Integer, Integer> getMap(String t) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int key = t.charAt(i);
            if (map.containsKey(key)) {
                int count = map.get(key);
                count++;
                map.put(key, count);
            } else {
                map.put(key, 1);
            }
        }
        return map;
    }


}
