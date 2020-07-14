package 数组与矩阵;
import java.util.*;

/**
 * LeeCode_54螺旋矩阵 同 剑指offer_19顺时针打印矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 */
public class No_54螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return list;
        }
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            // 第一行，从左至右
            for (int i = c1; i <= c2; i++) {
                list.add(matrix[r1][i]);
            }
            r1++;

            // 右边一列，从上至下
            if (r1 <= r2 && c1 <= c2) {
               for (int i = r1; i <= r2; i++) {
                   list.add(matrix[i][c2]);
               }
               c2--;
            }

            // 下面一行，从右至左
            if (r1 <= r2 && c1 <= c2) {
                for (int i = c2; i >= c1; i--) {
                    list.add(matrix[r2][i]);
                }
                r2--;
            }

            // 右边一列，从下至上
            if (r1 <= r2 && c1 <= c2) {
                for (int i = r2; i >= r1; i--) {
                    list.add(matrix[i][c1]);
                }
                c1++;
            }
        }
        return list;
    }
}
