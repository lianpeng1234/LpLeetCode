package com.lp.leetcode.other;

public class LeetCode79 {

    public static void main(String[] args) {
        char[][] board = new char[][]{{'a', 'a'}, {'a', 'a'}, {'a', 'a'}};
        String word = "aaaaaa";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        char[] wardChar = word.toCharArray();
        int row = 0;
        int column = 0;
        int[][] path = new int[board.length][board[0].length];
        while (row < board.length) {
            boolean find = xxxx(board, wardChar, 0, row, column, path);
            if (find) {
                return find;
            }

            if (column < board[row].length - 1) {
                column++;
            } else {
                column = 0;
                row++;
            }
        }
        return false;
    }

    // 二维数组path 记录，走的路线
    public static boolean xxxx(char[][] board, char[] wordChar, int wordIndex, int row, int column, int[][] path) {
        if (row == board.length || row == -1) {
            return false;
        }
        if (column == board[row].length || column == -1) {
            return false;
        }
        if (path[row][column] == 1) {
            return false;
        }

        char c = wordChar[wordIndex];
        path[row][column] = 1;
        if (c == board[row][column]) {
            if (wordIndex == wordChar.length - 1) {
                return true;
            } else {
                boolean find = xxxx(board, wordChar, wordIndex + 1, row, column + 1, path);
                if (find) {
                    return true;
                }

                find = xxxx(board, wordChar, wordIndex + 1, row, column - 1, path);
                if (find) {
                    return true;
                }

                find = xxxx(board, wordChar, wordIndex + 1, row + 1, column, path);
                if (find) {
                    return true;
                }

                find = xxxx(board, wordChar, wordIndex + 1, row - 1, column, path);
                if (find) {
                    return true;
                }
            }
        }
        path[row][column] = 0;
        return false;
    }

}
