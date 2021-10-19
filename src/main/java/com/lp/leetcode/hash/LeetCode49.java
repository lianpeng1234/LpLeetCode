package com.lp.leetcode.hash;

import java.util.*;

public class LeetCode49 {

    public static void main(String[] args) {
        String[] a = new String[]{"cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc"};
//        for (int i = 0; i < a.length; i++) {
//            int sum = 0;
//            String str = a[i];
//            for (int j = 0; j < str.length(); j++) {
//                sum += str.charAt(j);
//            }
//            System.out.println(str + " " + sum);
//        }

        groupAnagrams(a);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int l = strs.length;
        for (int i = 0; i < l; i++) {
            char[] abc = strs[i].toCharArray();
            Arrays.sort(abc);
            String key = new String(abc);
            if(map.containsKey(key)) {
                map.get(key).add(strs[i]);
            } else {
                List<String> list = new LinkedList<>();
                list.add(strs[i]);
                map.put(key, list);
            }
        }
        return new LinkedList<>(map.values());
    }


}
