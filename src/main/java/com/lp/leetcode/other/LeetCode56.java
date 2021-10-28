package com.lp.leetcode.other;

import java.util.Arrays;

public class LeetCode56 {
    public static void main(String[] args) {
        int[][] intervals = new int[1][2];
        intervals[0][0] = 1;
        intervals[0][1] = 3;

//        intervals[1][0] = 5;
//        intervals[1][1] = 6;
//
//        intervals[2][0] = 8;
//        intervals[2][1] = 10;
//
//        intervals[3][0] = 15;
//        intervals[3][1] = 18;
//
//        intervals[4][0] = 16;
//        intervals[4][1] = 20;

        int[][] aa = merge(intervals);
        System.out.println(Arrays.toString(aa));
    }

    public static int[][] merge(int[][] intervals) {
        Node[] nodes = new Node[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            nodes[i] = new Node(intervals[i][0], intervals[i][1]);
        }
        Arrays.sort(nodes);

        for (int i = 0; i < nodes.length - 1; i++) {
            Node a = nodes[i];
            Node b = nodes[i + 1];
            if (a.getEnd() >= b.getStart()) {
                nodes[i] = null;
                b.setStart(a.getStart());
                b.setEnd(Math.max(a.getEnd(), b.getEnd()));
                nodes[i + 1] = b;
            }
        }

        int[][] abc = new int[intervals.length][2];
        int saveIndex = 0;
        for (Node node : nodes) {
            if (node != null) {
                abc[saveIndex][0] = node.getStart();
                abc[saveIndex][1] = node.getEnd();
                saveIndex++;
            }
        }

        int[][] xx = new int[saveIndex][2];
        for (int x = 0; x < saveIndex; x++) {
            xx[x][0] = abc[x][0];
            xx[x][1] = abc[x][1];
        }

        return xx;
    }

    static class Node implements Comparable<Node> {
        private int start;
        private int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public Node setStart(int start) {
            this.start = start;
            return this;
        }

        public int getEnd() {
            return end;
        }

        public Node setEnd(int end) {
            this.end = end;
            return this;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.start, o.start);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

}
