package com.lp.leetcode.stack;

/**
 * 移除无效括号
 */
public class LeetCode1249 {

    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValid(s));
    }

    public static String minRemoveToMakeValid(String s) {
        char[] stack = new char[s.length()];
        int stackTop = -1;  // 记录栈针位置

        int[] deleteIndex = new int[s.length()];// 记录需要删除的 字符 索引

        int forIndex = 0; // 记录遍历到字符串，字符的索引位置

        while (forIndex < s.length()) {
            char sChar = s.charAt(forIndex);
            if (sChar == 40 || sChar == 41) {// 只让括号字符 “(”  “)”  入栈
                if (stackTop == -1) {// 当前栈为空
                    stackTop++;
                    stack[stackTop] = sChar; // 入栈
                    deleteIndex[stackTop] = forIndex; // 记录字符索引位置
                } else {
                    if (sChar - stack[stackTop] == 1) { // 括号匹配上了，出栈
                        stackTop--;
                    } else { // 括号未匹配上
                        stackTop++;
                        stack[stackTop] = sChar; // 入栈
                        deleteIndex[stackTop] = forIndex; // 记录字符索引位置
                    }
                }
            }

            forIndex++;
        }

        // 删除字符串中指定字符
        char[] newChar = new char[s.length()];

        int lp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (lp <= stackTop && i == deleteIndex[lp]) {
                newChar[i] = 43;
                lp++;
            } else {
                newChar[i] = s.charAt(i);
            }
        }
        return new String(newChar).replace("+", "");
    }


}



