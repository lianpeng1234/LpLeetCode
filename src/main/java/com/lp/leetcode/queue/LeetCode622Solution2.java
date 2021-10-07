package com.lp.leetcode.queue;

import java.util.LinkedList;

public class LeetCode622Solution2 {

}

// 使用链表
class MyCircularLinkQueue {

    private final LinkedList<Integer> queue = new LinkedList<>();
    private final int length;
    private int count = 0;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularLinkQueue(int k) {
        length = k;
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return count == length;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        count++;
        return queue.add(value);
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if(isEmpty()) {
            return false;
        }
        count--;
        queue.removeFirst();
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        // 队列是否空
        if (isEmpty()) {
            return -1;
        }
        return queue.getFirst();
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        // 队列是否空
        if (isEmpty()) {
            return -1;
        }
        return queue.getLast();
    }

}
