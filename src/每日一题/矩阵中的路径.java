package 每日一题;

import java.util.Iterator;

/**
 *
 */
public class 矩阵中的路径 {
    //上下左右四个方向
    private final int[][] next = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    private int rows;
    private int cols;

    public boolean hasPath(char[] array, int rows, int cols, char[] str) {
        if (rows == 0 || cols == 0) {
            return false;
        }
        this.rows = rows;
        this.cols = cols;
        boolean[][] marked = new boolean[rows][cols];
        char[][] matrix = buildMatrix(array);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtracking(matrix, str, marked, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(char[][] matrix, char[] str, boolean[][] marked, int pathLen, int r, int c) {
        if (pathLen == str.length) {
            return true;
        }
        if (r < 0 || r >= rows || c < 0 || c >= cols || matrix[r][c] != str[pathLen] || marked[r][c]) {
            return false;
        }
        //开始一次搜索
        marked[r][c] = true;
        for (int[] n : next) {
            if (backtracking(matrix, str, marked, pathLen + 1, r + n[0], c + n[1])) {
                return true;
            }
        }
        //每次搜索结束后都要，回溯（回退），将这一次搜索过程中设置的状态进行清楚，从而开始新一次的搜索。
        marked[r][c] = false;
        //没有成功搜索到
        return false;
    }


    private char[][] buildMatrix(char[] array) {
        char[][] matrix = new char[rows][cols];
        for (int i = 0, idx = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = array[idx++];
            }
        }
        return matrix;
    }
}
