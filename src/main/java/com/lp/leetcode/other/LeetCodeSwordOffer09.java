package com.lp.leetcode.other;

import java.util.LinkedList;

public class LeetCodeSwordOffer09 {

    public class CQueue {
        private LinkedList<Integer> s1 = new LinkedList<>();
        private LinkedList<Integer> s2 = new LinkedList<>();

        public CQueue() {

        }

        public void appendTail(int value) {
            if (s1.isEmpty()) {
                s1.addFirst(value);
            } else {
                while (!s1.isEmpty()) {
                    s2.addFirst(s1.getFirst());
                    s1.removeFirst();
                }
                s1.addFirst(value);
                while (!s2.isEmpty()) {
                    s1.addFirst(s2.getFirst());
                    s2.removeFirst();
                }

            }
        }

        public int deleteHead() {
            if (s1.isEmpty()) {
                return -1;
            }
            int value = s1.getFirst();
            s1.removeFirst();
            return value;
        }
    }

}


