package com.lp.leetcode.other;

import java.util.*;

public class LeetCode500 {
    public String[] findWords(String[] words) {
        Set<Character> set1 = new HashSet<>();
        set1.add('q');
        set1.add('w');
        set1.add('e');
        set1.add('r');
        set1.add('t');
        set1.add('y');
        set1.add('u');
        set1.add('i');
        set1.add('o');
        set1.add('p');

        Set<Character> set2 = new HashSet<>();
        set2.add('a');
        set2.add('s');
        set2.add('d');
        set2.add('f');
        set2.add('g');
        set2.add('h');
        set2.add('j');
        set2.add('k');
        set2.add('l');

        Set<Character> set3 = new HashSet<>();
        set3.add('z');
        set3.add('x');
        set3.add('c');
        set3.add('v');
        set3.add('b');
        set3.add('n');
        set3.add('m');

        int tag = 0;
        List<String> list = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            String str = words[i].toLowerCase();

            if (set1.contains(str.charAt(0))) {
                tag = 1;
            } else if (set2.contains(str.charAt(0))) {
                tag = 2;
            } else if (set3.contains(str.charAt(0))) {
                tag = 3;
            }

            for (int j = 0; j < str.length(); j++) {
                if (tag == 1) {
                    if (set1.contains(str.charAt(j))) {
                        if (j == str.length() - 1) {
                            list.add(words[i]);
                        }
                    } else {
                        break;
                    }
                } else if (tag == 2) {
                    if (set2.contains(str.charAt(j))) {
                        if (j == str.length() - 1) {
                            list.add(words[i]);
                        }
                    } else {
                        break;
                    }
                } else if (tag == 3) {
                    if (set3.contains(str.charAt(j))) {
                        if (j == str.length() - 1) {
                            list.add(words[i]);
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return list.toArray(new String[]{});
    }
}
