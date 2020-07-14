package 每日一题;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵：
 * 1  2  3  4
 * 5  6  7  8
 * 9  10 11 12
 * 13 14 15 16
 * 则依次打印出数字
 * 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class 顺时针打印矩阵 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return ret;
        }
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        //从[0,0]开始顺时针遍历
        while (r1 <= r2 && c1 <= c2) {
            //每圈的开始
            //从左至右打印上面一行
            for (int i = c1; i <= c2; i++)
                ret.add(matrix[r1][i]);
            //从上至下打印右边一列
            if (r1 != r2) {
                for (int i = r1 + 1; i <= r2; i++)
                    ret.add(matrix[i][c2]);
            }
            //从右至左打印下面一行
            if (r1 != r2 && c1 < c2) {
                for (int i = c2 - 1; i >= r1; i--)
                    ret.add(matrix[r2][i]);
            }
            //从下至上打印左边一列
            if (c1 != c2 && r1 < r2 - 1) {
                for (int i = r2 - 1; i >= r1 + 1; i--)
                    ret.add(matrix[i][c1]);
            }
            r1++;r2--;c1++;c2--;
        }
        return ret;
    }
}
