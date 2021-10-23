package com.lp.leetcode.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode6 {

    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        Map<Integer, List<Character>> map = new HashMap<>();
        int row = 1;
        boolean isDown = true;
        for (int i = 0; i < s.length(); i++) {
            List<Character> list = map.getOrDefault(row, new ArrayList<>());
            list.add(s.charAt(i));
            map.put(row, list);
            if (isDown) {
                row++;
            } else {
                row--;
            }
            if (row > numRows) {
                row = row - 2;
                isDown = false;
            }
            if (row < 1) {
                row = row + 2;
                isDown = true;
            }
        }

        StringBuilder str = new StringBuilder();
        for (int i = 1; i <= numRows; i++) {
            List<Character> list = map.get(i);
            if (list == null) {
                continue;
            }
            for (Character c : list) {
                str.append(c);
            }
        }
        return str.toString();
    }

}
