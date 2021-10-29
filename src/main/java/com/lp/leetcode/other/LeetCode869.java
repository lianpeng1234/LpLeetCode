package com.lp.leetcode.other;

import java.util.Arrays;

public class LeetCode869 {

    public boolean reorderedPowerOf2(int n) {
        String[] rec = {"1", "2", "4", "8", "16", "23", "46", "128", "256", "125", "0124", "0248", "0469", "1289", "13468",
                "23678", "35566", "011237", "122446", "224588", "0145678", "0122579", "0134449", "0368888",
                "11266777", "23334455", "01466788", "112234778", "234455668", "012356789", "0112344778"};
        char[] at = String.valueOf(n).toCharArray();
        Arrays.sort(at);
        String str = new String(at);
        for (String p : rec) {
            if (str.equals(p)) return true;
        }
        return false;
    }


}
