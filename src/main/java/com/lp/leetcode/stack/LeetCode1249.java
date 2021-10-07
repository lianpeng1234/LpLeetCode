package com.lp.leetcode.stack;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1249 {

    public boolean backspaceCompare(String S, String T) {
        List<Integer> cs = sss(S);
        List<Integer> ts = sss(T);
        if (cs.size() != ts.size()) {
            return false;
        }
        for (int i = 0; i < cs.size(); i++) {
            if (cs.get(i).intValue() != ts.get(i).intValue()) {
                return false;
            }
        }

        return true;
    }

    private List<Integer> sss(String s) {
        List<Integer> list = new ArrayList<>();

        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            int c = (int) cs[i];
            if (c == 35) {
                int size = list.size();
                if (size > 0) {
                    list.remove(size - 1);
                }
            } else {
                list.add(c);
            }
        }
        return list;
    }


}



