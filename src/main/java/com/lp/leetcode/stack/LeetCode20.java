package com.lp.leetcode.stack;

import java.util.ArrayList;
import java.util.List;

public class LeetCode20 {

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            int c = (int) chars[i];
            if (list.size() == 0) {
                list.add(c);
                continue;
            }
            int index = list.size() - 1;
            int l = list.get(index);
            if (c == 41 && l == 40) {
                list.remove(index);
                continue;
            }
            if (c == 125 && l == 123) {
                list.remove(index);
                continue;
            }
            if (c == 93 && l == 91) {
                list.remove(index);
                continue;
            }
            list.add(c);
        }

        return list.isEmpty();
    }


}



