package com.lp.leetcode.stack;

import java.util.ArrayList;
import java.util.List;

public class LeetCode20L2 {

    public static void main(String[] args) {
        String s = "()";

        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        if (s.length() == 1) {
            return false;
        }

        char[] stack = new char[s.length() / 2 + 1];// 初始化栈容量，只需初始初始化为，字符串长度的一半加 1
        int stackTop = 0;// 记录当前栈针位置，

        int length = s.length();
        int xx = length - 1;
        for (int i = 0; i < length; i++) {
            char sC = s.charAt(i);// 时间，换空间
            if (stackTop == 0) {  // 栈为空 入栈
                stack[stackTop] = sC;
                stackTop++;
            } else {
                int aaa = sC - stack[stackTop-1];// 栈不为空，出栈并比较（不是真正的将元素从数组中删除）
                if (aaa == 1 || aaa == 2) { // 符合要求
                    stackTop--; // 出栈
                } else {
                    stack[stackTop] = sC;// 不符合要求，入栈
                    stackTop++;
                }
            }

            if (stackTop == stack.length) {// 当前栈元素已慢，说明字符串本身 不是“有效的括号”
                return false;
            }
            if (stackTop == 0 && i == xx) {// 字符串每个字符校验完毕，并且 stackTop 为 0，说明字符串是 “有效的括号”
                return true;
            }
        }

        return true;
    }


}



