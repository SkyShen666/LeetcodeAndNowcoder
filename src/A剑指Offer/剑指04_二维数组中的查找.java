package A剑指Offer;

public class 剑指04_二维数组中的查找 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;

        // 从左下角找
        int i = m - 1;
        int j = 0;

        while (i >= 0) {
            while (j < n && matrix[i][j] < target) {
                j++;
            }
            if (j < n && matrix[i][j] == target) {
                return true;
            }
            i--;
        }

        return false;
    }
}
