package com.lp.leetcode.queue;

public class LeetCode622Solution1 {

}

// 使用数组
class MyCircularArrayQueue {

    // 队尾数组下标计算方式如下
    // headIndex 队头数组下标
    // count 队列长度
    // capacity 队列容量
    // tailIndex = ( headIndex + count − 1) % capacity

    // 队列容量
    private final int[] queue;

    // 队头数组下标
    private int headIndex = 0;

    // 当前添加元素的数组下标
    private int currencyAddIndex = 0;

    // 队列长度
    private int count = 0;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularArrayQueue(int k) {
        queue = new int[k];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        // 队列是否空
        return count == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return count == queue.length;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        // 判断队列是否满了
        if (isFull()) {
            return false;
        }

        queue[currencyAddIndex] = value;
        if (currencyAddIndex == queue.length - 1) {
            currencyAddIndex = 0;
        } else {
            currencyAddIndex++;
        }
        count++;

        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        // 判断队列是否空
        if (isEmpty()) {
            return false;
        }
        count--;
        if (headIndex == queue.length - 1) {
            headIndex = 0;
        } else {
            headIndex++;
        }
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

        return queue[headIndex];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        // 队列是否空
        if (isEmpty()) {
            return -1;
        }
        int tailIndex = (headIndex + count -1) % queue.length;
        return queue[tailIndex];
    }

}
