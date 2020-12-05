package 数组与矩阵;
import java.util.*;

public class 面试题01_08零矩阵 {
    private int[][] matrix;
    private int m;
    private int n;

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        Deque<int[]> points = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    points.add(new int[]{i, j});
                }
            }
        }

        for (int[] point : points) {
            reset(point[0], point[1]);
        }
    }

    private void reset(int i, int j) {
        for (int k = 0; k < m; k++) {
            matrix[k][j] = 0;
        }
        for (int k = 0; k < n; k++) {
            matrix[i][k] = 0;
        }
    }
}
