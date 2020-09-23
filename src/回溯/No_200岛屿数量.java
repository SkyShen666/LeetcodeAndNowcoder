package 回溯;

public class No_200岛屿数量 {
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private char[][] grid;
    private boolean[][] visited;
    private int n;
    private int m;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        n = grid.length;
        m = grid[0].length;
        this.grid = grid;
        visited = new boolean[n][m];
        int count = 0;
        // 开始遍历每一个格子
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 发现还没有访问过的陆地
                if (!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(i, j);
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j) {
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int nextX = i + dx[k];
            int nextY = j + dy[k];
            // 下一个访问点：1、不越界 2、陆地 3、未曾访问
            if (nextX >= 0 && nextX < n && nextY >=0 && nextY < m && grid[nextX][nextY] == '1' && !visited[nextX][nextY]) {
                dfs(nextX, nextY);
            }
        }
    }
}
