package com.lp.leetcode.game;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LeetCode26601 {

    public static void main(String[] args) {
        int x = countVowelSubstrings("aeiouu");
        System.out.println(x);
    }

    public static int countVowelSubstrings(String word) {
        int allCount = 0;
        Map<Character, Integer> map = resetMap();
        for (int i = 0; i < word.length(); i++) {
            if (!map.containsKey(word.charAt(i))) {
                continue;
            }
            for (int j = i; j < word.length(); j++) {
                if (!map.containsKey(word.charAt(j))) {
                    break;
                }
                int count = map.getOrDefault(word.charAt(j), 0);
                count++;
                map.put(word.charAt(j), count);
                if (check(map)) {
                    allCount++;
                }
            }
            map = resetMap();
        }

        return allCount;
    }

    private static Map<Character, Integer> resetMap() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('e', 0);
        map.put('i', 0);
        map.put('o', 0);
        map.put('u', 0);
        return map;
    }

    private static boolean check(Map<Character, Integer> map) {
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            if (entry.getValue() == 0) {
                return false;
            }
        }
        return true;
    }


}


