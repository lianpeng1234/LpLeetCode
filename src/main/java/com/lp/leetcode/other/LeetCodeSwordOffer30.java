package com.lp.leetcode.other;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class LeetCodeSwordOffer30 {

    private PriorityQueue<Integer> queue;

    private LinkedList<Integer> stack;

    public LeetCodeSwordOffer30() {
        stack = new LinkedList<>();
        queue = new PriorityQueue<>();
    }

    // 入栈
    public void push(int x) {
        stack.addFirst(x);
        queue.offer(x);
    }

    // 删除栈顶元素
    public void pop() {
        if (stack.size() > 0) {
            int a = stack.getFirst();
            stack.removeFirst();
            queue.remove(a);
        }
    }

    // 获取栈顶元素
    public int top() {
        return stack.getFirst();
    }

    // 检索栈中的最小元素，使用最小堆实现
    public int min() {
        return queue.peek();
    }

}
