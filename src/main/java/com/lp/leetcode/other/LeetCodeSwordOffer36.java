package com.lp.leetcode.other;

import java.util.ArrayList;
import java.util.List;

public class LeetCodeSwordOffer36 {

    public static void main(String[] args) {
        Node node1 = new Node(1, null, null);
        Node node3 = new Node(3, null, null);
        Node node5 = new Node(5, null, null);
        Node node2 = new Node(2, node1, node3);
        Node node4 = new Node(4, node2, node5);

        LeetCodeSwordOffer36 lc = new LeetCodeSwordOffer36();

        Node xx = lc.treeToDoublyList(node4);
        System.out.println();
    }

    public Node treeToDoublyList(Node root) {
        List<Integer> list = new ArrayList<>();
        diGui(root, list);
        Node head = null;
        Node tmpHead = null;
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                head = new Node(list.get(i), null, null);
                tmpHead = head;
                head.right = head;
                head.left = head;
            } else if (i < list.size() - 1) {
                Node node = new Node(list.get(i), null, null);
                tmpHead.right = node;
                node.left = tmpHead;
                tmpHead = node;
            } else {
                Node node = new Node(list.get(i), null, null);
                tmpHead.right = node;
                node.left = tmpHead;
                node.right = head;
                head.left = node;
            }
        }
        return head;
    }

    private void diGui(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        diGui(node.left, list);
        list.add(node.val);
        diGui(node.right, list);
    }


    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
