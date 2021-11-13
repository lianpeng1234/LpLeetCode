package com.lp.leetcode.other;

import java.util.ArrayList;
import java.util.List;

public class LeetCode101 {

    public boolean isSymmetric(TreeNode root) {
        List<String> list = new ArrayList<>();
        recursion(root, list, null, 0);
        System.out.println(list);

        int begin = 0;
        int after = list.size() - 1;
        while (begin <= after) {
            if (fuck(list.get(begin), list.get(after))) {
                begin++;
                after--;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean fuck(String be, String af) {
        String[] x = be.split("-");
        String[] xx = af.split("-");
        for (int i = 0; i < 2; i++) {
            if (!x[i].equals(xx[i])) {
                return false;
            }
        }
        if (x[2].equals("left") && xx[2].equals("right")) {
            return true;
        }
        if (x[2].equals("right") && xx[2].equals("left")) {
            return true;
        }
        if (x[2].equals("null") && xx[2].equals("null")) {
            return true;
        }
        System.out.print(be + "    " + af);
        System.out.println();
        return false;
    }

    private void recursion(TreeNode node, List<String> list, String tag, int depth) {
        if (node == null) {
            return;
        }
        recursion(node.left, list, "left", depth + 1);
        list.add(node.val + "-" + depth + "-" + tag);
        recursion(node.right, list, "right", depth + 1);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
