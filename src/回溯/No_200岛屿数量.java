package 回溯;

public class No_200岛屿数量 {
    private int[] di = {1, -1, 0, 0};
    private int[] dj = {0, 0, -1, 1};
    private char[][] grid;
    private int m;
    private int n;
    private boolean[][] visited;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        int cnt = 0;

        // 开始遍历每一个格子
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 发现还没有访问过的陆地
                if (!visited[i][j] && grid[i][j] == '1') {
                    cnt++;
                    dfs(i, j);
                }
            }
        }

        return cnt;
    }

    private void dfs(int i, int j) {
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int nextI = i + di[k];
            int nextJ = j + dj[k];
            // 下一个访问点：1、不越界 2、陆地 3、未曾访问 4、是陆地
            if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n && !visited[nextI][nextJ] && grid[nextI][nextJ] == '1') {
                dfs(nextI, nextJ);
            }
        }
    }
}
