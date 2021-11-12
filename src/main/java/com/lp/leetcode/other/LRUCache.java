package com.lp.leetcode.other;

import java.util.HashMap;

// 146. LRU 缓存机制
public class LRUCache {

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        // 已经存在，更新值
        cache.get(1);
        cache.put(3, 3);
        cache.get(2);
        cache.put(4, 4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }

    private final HashMap<Integer, Node> map = new HashMap<>(10);

    private final int capacity;

    private int size = 0;

    private final Node head = new Node(-1, -1);

    private final Node tail = new Node(-2, -2);

    public LRUCache(int capacity) {
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
    }

    public synchronized int get(int key) {
        Node node = map.getOrDefault(key, null);
        // 不在缓存中
        if (node == null) {
            return -1;
        }

        // 移动到链表头部
        moveNodeToHead(node);

        return node.value;
    }

    private void moveNodeToHead(Node node) {
        // 节点已经在链表头部
        if (node.pre.equals(head)) {
            return;
        }
        // 将节点移动到链表头部
        Node nodePre = node.pre;
        Node nodeNext = node.next;

        nodePre.next = nodeNext;
        nodeNext.pre = nodePre;

        node.next = head.next;
        node.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    public synchronized void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {// 已在缓存中
            // 移动到链表头部
            moveNodeToHead(node);
            // 更新值
            node.value = value;
            return;
        }

        if (size < capacity) {// 容量未满
            putPut(key, value);
        } else {// 容量满了
            // 将节点从map中删除
            map.remove(tail.pre.key);
            // 删除链表末尾元素

            tail.pre.pre.next = tail;
            tail.pre = tail.pre.pre;

            size--;
            // 加入链表头
            putPut(key, value);
        }
    }

    private void putPut(int key, int value) {
        Node node;

        node = new Node(key, value);
        node.next = head.next;
        node.next.pre = node;

        head.next = node;
        node.pre = head;

        map.put(key, node);

        size++;
    }

    private static class Node {
        private int key;
        private int value;
        private Node pre;
        private Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public Node setKey(int key) {
            this.key = key;
            return this;
        }

        public int getValue() {
            return value;
        }

        public Node setValue(int value) {
            this.value = value;
            return this;
        }

        public Node getPre() {
            return pre;
        }

        public Node setPre(Node pre) {
            this.pre = pre;
            return this;
        }

        public Node getNext() {
            return next;
        }

        public Node setNext(Node next) {
            this.next = next;
            return this;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }


}
