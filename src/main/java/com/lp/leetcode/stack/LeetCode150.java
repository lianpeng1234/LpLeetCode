package com.lp.leetcode.stack;

import org.junit.Test;

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

public class LeetCode150 {

    @Test
    public void xxx() {

    }

    public int evalRPN(String[] tokens) {
        String add = "+";
        String reduce = "-";
        String multiplication = "*";
        String division = "/";

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            String str = tokens[i];
            if (!str.equals(add) && !str.equals(reduce) && !str.equals(multiplication) && !str.equals(division)) {
                list.addFirst(Integer.parseInt(str));
            } else {
                if (str.equals(add)) {
                    Integer a = list.getFirst();
                    list.removeFirst();
                    Integer b = list.getFirst();
                    list.removeFirst();
                    int xx = b + a;
                    list.addFirst(xx);
                } else if (str.equals(reduce)) {
                    Integer a = list.getFirst();
                    list.removeFirst();
                    Integer b = list.getFirst();
                    list.removeFirst();
                    int xx = b - a;
                    list.addFirst(xx);
                } else if (str.equals(multiplication)) {
                    Integer a = list.getFirst();
                    list.removeFirst();
                    Integer b = list.getFirst();
                    list.removeFirst();
                    int xx = b * a;
                    list.addFirst(xx);
                } else if (str.equals(division)) {
                    Integer a = list.getFirst();
                    list.removeFirst();
                    Integer b = list.getFirst();
                    list.removeFirst();
                    int xx = b / a;
                    list.addFirst(xx);
                }
            }
        }

        return list.getFirst();
    }
}
