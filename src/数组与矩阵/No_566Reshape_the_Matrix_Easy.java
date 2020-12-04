package 数组与矩阵;

public class No_566Reshape_the_Matrix_Easy {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int m = nums.length;
        int n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }

        int[][] res = new int[r][c];
        int row = 0, col = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[row][col] = nums[i][j];
                col++;
                if (col == c) {
                    row++;
                    col = 0;
                }
            }
        }

        return res;
    }
}
