package 动态规划;

/**
 * 动态规划解决。
 * 坑点：matrix 是 char类型数组
 */
public class No_221最大正方形 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0] == '0' ? 0 : 1;
            max = Math.max(max, dp[i][0]);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i] == '0' ? 0 : 1;
            max = Math.max(max, dp[0][i]);
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]),
                            dp[i][j - 1]);
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
