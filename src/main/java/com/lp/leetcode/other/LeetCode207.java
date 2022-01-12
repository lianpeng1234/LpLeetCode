package com.lp.leetcode.other;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode207 {

    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}};
        canFinish(20, prerequisites);
    }

    // 通过拓扑排序，判断图中是否存在环
    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        // 图的节点的出度
        Map<Integer, Set<Integer>> mapOut = new HashMap<>();
        // 图的节点的入度
        Map<Integer, Set<Integer>> mapIn = new HashMap<>();
        // 构建节点的出入度
        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];

            Set<Integer> outB = mapOut.getOrDefault(b, new HashSet<>());
            outB.add(a);
            mapOut.put(b, outB);

            Set<Integer> inA = mapIn.getOrDefault(a, new HashSet<>());
            inA.add(b);
            mapIn.put(a, inA);
        }

        while (true) {
            // 找出入度是 0 的节点
            Set<Integer> zeroInNode = new HashSet<>();
            mapOut.forEach((key, value) -> {
                if (!mapIn.containsKey(key)) {
                    zeroInNode.add(key);
                }
            });

            if (zeroInNode.size() <= 0 && mapIn.size() > 0) {
                return false;
            }

            if (mapIn.size() <= 0) {
                return true;
            }

            // 删除入度是 0 的节点
            zeroInNode.forEach(key -> {
                Set<Integer> setOut = mapOut.get(key);
                setOut.forEach(abc -> {
                    Set<Integer> setIn = mapIn.get(abc);
                    if (setIn != null) {
                        setIn.remove(key);
                        if (setIn.size() <= 0) {
                            mapIn.remove(abc);
                        }
                    }
                });
                mapOut.remove(key);
            });
        }
    }

}
