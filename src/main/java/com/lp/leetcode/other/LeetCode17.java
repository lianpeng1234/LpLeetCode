package com.lp.leetcode.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode17 {

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        ;
    }

    public static List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> list = new ArrayList<>();
        if (digits.length() == 0) {
            return list;
        }


        if (digits.length() == 1) {
            String s1 = map.get(digits.charAt(0));
            for (int i = 0; i < s1.length(); i++) {
                StringBuilder sb = new StringBuilder();
                list.add(sb.append(s1.charAt(i)).toString());
            }
        }
        if (digits.length() == 2) {
            String s1 = map.get(digits.charAt(0));
            String s2 = map.get(digits.charAt(1));
            for (int i = 0; i < s1.length(); i++) {
                for (int j = 0; j < s2.length(); j++) {
                    StringBuilder sb = new StringBuilder();
                    list.add(sb.append(s1.charAt(i)).append(s2.charAt(j)).toString());
                }
            }
        }
        if (digits.length() == 3) {
            String s1 = map.get(digits.charAt(0));
            String s2 = map.get(digits.charAt(1));
            String s3 = map.get(digits.charAt(2));
            for (int i = 0; i < s1.length(); i++) {
                for (int j = 0; j < s2.length(); j++) {
                    for (int k = 0; k < s3.length(); k++) {
                        StringBuilder sb = new StringBuilder();
                        list.add(sb.append(s1.charAt(i)).append(s2.charAt(j)).append(s3.charAt(k)).toString());
                    }
                }
            }
        }
        if (digits.length() == 4) {
            String s1 = map.get(digits.charAt(0));
            String s2 = map.get(digits.charAt(1));
            String s3 = map.get(digits.charAt(2));
            String s4 = map.get(digits.charAt(3));
            for (int i = 0; i < s1.length(); i++) {
                for (int j = 0; j < s2.length(); j++) {
                    for (int k = 0; k < s3.length(); k++) {
                        for (int x = 0; x < s4.length(); x++) {
                            StringBuilder sb = new StringBuilder();
                            list.add(sb.append(s1.charAt(i)).append(s2.charAt(j)).append(s3.charAt(k)).append(s4.charAt(x)).toString());
                        }
                    }
                }
            }
        }

        return list;
    }


}
