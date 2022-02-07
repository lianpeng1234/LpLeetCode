package com.lp.leetcode.other;

import java.util.LinkedList;

public class LeetCodeSwordOffer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> stack = new LinkedList<>();
        int length = pushed.length;
        boolean finishPush = false;

        int pushIndex = 0;
        int popIndex = 0;
        while (popIndex < length) {
            if (stack.size() > 0) {
                if (stack.getFirst() == popped[popIndex]) {
                    stack.removeFirst();
                    popIndex++;
                    continue;
                } else if (finishPush) {
                    break;
                }
            }

            if (pushIndex < length) {
                stack.addFirst(pushed[pushIndex]);
                pushIndex++;
            } else {
                finishPush = true;
            }
        }

        return stack.size() == 0;
    }
}
