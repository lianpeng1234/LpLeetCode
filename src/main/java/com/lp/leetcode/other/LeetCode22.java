package com.lp.leetcode.other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

public class LeetCode22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        char[] chars = new char[n * 2];
        chars[0] = '(';

        recursion(chars, 1, result);

        return result;
    }

    private void recursion(char[] chars, int index, List<String> result) {
        if (index >= chars.length) {
            if (check(chars, index)) {
                result.add(new String(chars));
            }
            return;
        }

        chars[index] = '(';
        recursion(chars, index + 1, result);

        chars[index] = ')';
        recursion(chars, index + 1, result);
    }

    private boolean check(char[] chars, int length) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            if (stack.isEmpty()) {
                stack.addFirst(chars[i]);
            } else {
                if (stack.getFirst() == '(' && chars[i] == ')') {
                    stack.removeFirst();
                } else {
                    stack.addFirst(chars[i]);
                }
            }
        }
        return stack.isEmpty();
    }

}
