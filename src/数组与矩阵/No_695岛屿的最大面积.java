package 数组与矩阵;

public class No_695岛屿的最大面积 {
    private static final int[] di = {1, -1, 0, 0};
    private static final int[] dj = {0, 0, -1, 1};
    private int[][] grid;
    private int m;
    private int n;
    private int max;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(i, j));
                }
            }
        }

        return max;
    }

    private int dfs(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return 0;
        }

        int tmp = 1;
        grid[i][j] = 0;

        for (int k = 0; k < 4; k++) {
            int nextI = i + di[k];
            int nextJ = j + dj[k];
            tmp += dfs(nextI, nextJ);
        }

        return tmp;
    }
}
