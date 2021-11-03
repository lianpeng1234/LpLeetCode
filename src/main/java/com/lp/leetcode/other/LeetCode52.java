package com.lp.leetcode.other;

import java.util.ArrayList;
import java.util.List;

public class LeetCode52 {

    public static void main(String[] args) {
        totalNQueens(9);
    }

    public static int totalNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[][] position = new int[n][n];
            put(position, 0, i, 1, result);
        }
        return result.size();
    }

    // 放入皇后，并着色
    private static void put(int[][] position, int row, int column, int solveCode, List<List<String>> result) {
        // 该位置无法摆放
        if (position[row][column] != 0) {
            return;
        }

        // 可以摆放
        position[row][column] = solveCode;

        // 横线
        for (int i = 0; i < position[0].length; i++) {
            if (position[row][i] == 0) {
                position[row][i] = solveCode * 10;
            }
        }

        // 纵线
        for (int i = 0; i < position.length; i++) {
            if (position[i][column] == 0) {
                position[i][column] = solveCode * 10;
            }
        }

        // 四条斜线
        int columnColor = column;
        int rowI = row;
        while (columnColor < position[0].length - 1 && rowI < position.length - 1) {
            if (position[rowI + 1][columnColor + 1] == 0) {
                position[rowI + 1][columnColor + 1] = solveCode * 10;
            }
            rowI++;
            columnColor++;
        }

        columnColor = column;
        rowI = row;
        while (columnColor > 0 && rowI > 0) {
            if (position[rowI - 1][columnColor - 1] == 0) {
                position[rowI - 1][columnColor - 1] = solveCode * 10;
            }
            rowI--;
            columnColor--;
        }

        columnColor = column;
        rowI = row;
        while (columnColor < position[0].length - 1 && rowI > 0) {
            if (position[rowI - 1][columnColor + 1] == 0) {
                position[rowI - 1][columnColor + 1] = solveCode * 10;
            }
            rowI--;
            columnColor++;
        }

        columnColor = column;
        rowI = row;
        while (columnColor > 0 && rowI < position.length - 1) {
            if (position[rowI + 1][columnColor - 1] == 0) {
                position[rowI + 1][columnColor - 1] = solveCode * 10;
            }
            rowI++;
            columnColor--;
        }

        // 所有的皇后都放置完，输出放置方案
        if (solveCode >= position.length) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < position.length; i++) {
                StringBuilder line = new StringBuilder();
                for (int j = 0; j < position[i].length; j++) {
                    if (position[i][j] >= 1 && position[i][j] <= 9) {
                        line.append("Q");
                    } else {
                        line.append(".");
                    }
                }
                list.add(line.toString());
            }
            result.add(list);
            quit(position, solveCode);
            return;
        }

        for (int i = row + 1; i < position.length; i++) {// row + 1 是为
            for (int j = 0; j < position[i].length; j++) {
                put(position, i, j, solveCode + 1, result);
            }
        }
        quit(position, solveCode);
    }

    // 拿出皇后，并褪色
    private static void quit(int[][] position, int solveCode) {
        for (int i = 0; i < position.length; i++) {
            for (int j = 0; j < position[i].length; j++) {
                if (position[i][j] == solveCode * 10 || position[i][j] == solveCode) {
                    position[i][j] = 0;
                }
            }
        }
    }
}
