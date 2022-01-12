package com.lp.leetcode.other;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode07 {

    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        int[][] relatioon = new int[][]{{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}};
        LeetCode07 lc = new LeetCode07();
        int path = lc.numWays(n, relatioon, k);
        System.out.println(path);
    }

    private int transmitTimes;
    private int target;
    private int pathCount;
    private Map<Integer, Set<Integer>> map;

    public int numWays(int n, int[][] relation, int k) {
        transmitTimes = k;
        target = n - 1;
        map = new HashMap<>();
        for (int i = 0; i < relation.length; i++) {
            int a = relation[i][0];
            int b = relation[i][1];
            Set<Integer> set = map.getOrDefault(a, new HashSet<>());
            set.add(b);
            map.put(a, set);
        }

        if (!map.containsKey(0)) {
            return 0;
        }

        xxx(1, map.get(0));

        return pathCount;
    }

    private void xxx(int curTransmitTimes, Set<Integer> set) {
        if (set == null) {
            return;
        }
        if (curTransmitTimes == transmitTimes) {
            if (set.contains(target)) {
                pathCount++;
                return;
            }
            return;
        }
        for (Integer item : set) {
            xxx(curTransmitTimes+1, map.get(item));
        }
    }

}
