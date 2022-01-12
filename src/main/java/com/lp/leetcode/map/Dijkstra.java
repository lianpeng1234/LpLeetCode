package com.lp.leetcode.map;

import java.util.*;

// 最短路径 迪杰斯特拉 算法
public class Dijkstra {

    public static void main(String[] args) {
        int n = 5;
        int[][] flights = new int[][]{{0, 2, 2}, {0, 1, 10}, {1, 3, 25}, {1, 4, 15}, {2, 3, 40}, {3, 4, 8}, {2, 1, 5}};
        int src = 0;
        int dst = 2;
        System.out.println(findCheapestPrice(n, flights, src, dst));
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst) {
        // 构建 有向带权图
        Map<Integer, Map<Integer, Edgelp>> map = new HashMap<>();
        for (int i = 0; i < flights.length; i++) {
            int from = flights[i][0];
            int to = flights[i][1];
            int weight = flights[i][2];

            Map<Integer, Edgelp> arrive = map.getOrDefault(from, new HashMap<>());
            arrive.put(to, new Edgelp(from, to, weight, false));
            map.put(from, arrive);
        }

        // 构建 原点到各个顶点的距离
        Map<Integer, Edgelp> srcMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (i != src) {
                if (map.get(src).containsKey(i)) {
                    srcMap.put(i, map.get(src).get(i));
                } else {
                    srcMap.put(i, new Edgelp(src, i, Integer.MAX_VALUE, false));
                }
            }
        }

        // 记录被标记的顶点
//        boolean[] mark = new boolean[n];

        while (true) {
            Edgelp minEdgelp = getMinEdgelp(srcMap);
            if (minEdgelp == null) {
                System.out.println("不可达");
                break;
            }
            if (minEdgelp.to == dst) {
                System.out.println("最短距离 " + minEdgelp.weight);
                break;
            }

            minEdgelp.mark = true;

            Map<Integer, Edgelp> xxx = map.get(minEdgelp.to);
            xxx.forEach((to, edge) -> {
                int qq = minEdgelp.weight + edge.weight;
                if (qq < srcMap.get(to).weight) {
                    srcMap.get(to).weight = qq;
                }
            });
        }
        return -1;
    }

    private static Edgelp getMinEdgelp(Map<Integer, Edgelp> srcMap) {
        Edgelp min = null;
        Set<Map.Entry<Integer, Edgelp>> set = srcMap.entrySet();
        for (Map.Entry<Integer, Edgelp> item : set) {
            if (min == null) {
                min = item.getValue();
                continue;
            }
            if (min.weight > item.getValue().weight && !item.getValue().mark) {
                min = item.getValue();
            }
        }
        return min;
    }


    public static class Edgelp {
        public int from;
        public int to;
        public int weight;
        public boolean mark;

        public Edgelp(int from, int to, int weight, boolean mark) {
            this.from = from;
            this.to = to;
            this.weight = weight;
            this.mark = mark;
        }
    }


}
