package com.lp.leetcode.other;

import java.util.HashMap;

public class LeetCode575 {
    public int distributeCandies(int[] candyType) {
        int countType = 0;
        int up = candyType.length / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < candyType.length; i++) {
            int count = map.getOrDefault(candyType[i], 0);
            count++;
            map.put(candyType[i], count);
            if (count == 1 && countType < up) {
                countType++;
            }
        }
        return countType;
    }
}
