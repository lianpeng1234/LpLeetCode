package com.lp.leetcode.other;

import java.util.LinkedList;
import java.util.List;

public class LeetCode678 {
    // 双栈，一个放 左右括号 使用 A 表示，一个放 “*” 号 使用 B 表示
    // 遍历字符串，如果是 “*” 号放入 B 栈。如果是括号，先判断 A 栈顶元素是否符合 如果符合则弹出，不符合则判断 B 栈顶元素 如果符合则弹出 不符合则放入 A 栈。
    // *)、(* 是符合条件的，)*、*( 是不符合条件的
    public boolean checkValidString(String s) {
        LinkedList<Integer> leftBracket = new LinkedList<>();
        LinkedList<Integer> asterisk = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftBracket.addFirst(i);
            } else if (c == ')') {
                if (!leftBracket.isEmpty()) {
                    leftBracket.removeFirst();
                } else if (!asterisk.isEmpty()) {
                    asterisk.removeFirst();
                } else {
                    return false;
                }
            } else {
                asterisk.addFirst(i);
            }
        }

        while (!leftBracket.isEmpty() && !asterisk.isEmpty()) {
            int left = leftBracket.getFirst();
            int as = asterisk.getFirst();
            if (left > as) {
                return false;
            }
            leftBracket.removeFirst();
            asterisk.removeFirst();
        }

        return leftBracket.isEmpty();
    }
}
