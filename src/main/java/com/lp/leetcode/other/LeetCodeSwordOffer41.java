package com.lp.leetcode.other;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class LeetCodeSwordOffer41 {

    public static void main(String[] args) {
        LeetCodeSwordOffer41 lc = new LeetCodeSwordOffer41();
        lc.addNum(-1);
        lc.addNum(-2);
        lc.addNum(-3);
        lc.addNum(-4);
        lc.addNum(-5);
        System.out.println(lc.findMedian());
    }

    // 大顶堆
    private PriorityQueue<Integer> bigHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    // 小顶堆
    private PriorityQueue<Integer> littleHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    });

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public void addNum(int num) {
        if (atomicInteger.getAndIncrement() % 2 == 0) {
            if (littleHeap.size() > 0 && littleHeap.peek() <= num) {
                littleHeap.offer(num);
                num = littleHeap.poll();
                bigHeap.offer(num);
            } else {
                bigHeap.offer(num);
            }
        } else {
            if (bigHeap.size() > 0 && bigHeap.peek() > num) {
                bigHeap.offer(num);
                num = bigHeap.poll();
                littleHeap.offer(num);
            } else {
                littleHeap.offer(num);
            }
        }
    }

    public double findMedian() {
        if (atomicInteger.get() % 2 == 0) {
            double a1 = (double) bigHeap.peek();
            double a2 = (double) littleHeap.peek();
            return (a1 + a2) / 2;
        } else {
            double a1 = (double) bigHeap.peek();
            return a1;
        }
    }

}
