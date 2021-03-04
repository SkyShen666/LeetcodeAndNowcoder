package 每日一题;

public class 剑指13_机器人的运动范围 {
    private int m;
    private int n;
    private int k;
    private boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        visited = new boolean[m][n];

        // 从(0, 0) 点开始遍历
        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        if (i >= m || j >= n || k < sum(i, j) || visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;

        // 不走回头路
        return 1 + dfs(i + 1, j) + dfs(i, j + 1);
    }

    private int sum(int i, int j) {
        int cnt = 0;

        while (i > 0) {
            cnt += i % 10;
            i = i / 10;
        }
        while (j > 0) {
            cnt += j % 10;
            j = j / 10;
        }

        return cnt;
    }
}
