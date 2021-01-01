package 每日一题;

public class 剑指_29顺时针打印矩阵 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        int[] ret = new int[(r2 + 1) * (c2 + 1)];
        int cnt = 0;

        while (r1 <= r2 && c1 <= c2) {
            // 1. 最上一行，从左至右
            for (int j = c1; j <= c2; j++) {
                ret[cnt++] = matrix[r1][j];
            }
            r1++;

            // 2. 最右一列，从上至下
            if (r1 <= r2) {
                for (int i = r1; i <= r2; i++) {
                    ret[cnt++] = matrix[i][c2];
                }
                c2--;
            }

            // 3. 最下一行，从右至左
            if (r1 <= r2 && c1 <= c2) {
                for (int j = c2; j >= c1; j--) {
                    ret[cnt++] = matrix[r2][j];
                }
                r2--;
            }

            // 4. 最左一列，从下至上
            if (r1 <= r2 && c1 <= c2) {
                for (int i = r2; i >= r1; i--) {
                    ret[cnt++] = matrix[i][c1];
                }
                c1++;
            }
        }

        return ret;
    }
}
