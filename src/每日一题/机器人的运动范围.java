package 每日一题;

/**
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 */
public class 机器人的运动范围 {
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

        return 1 + dfs(i + 1, j) + dfs(i, j + 1);
    }

    private int sum(int i, int j) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i = i / 10;
        }
        while (j != 0) {
            sum += j % 10;
            j = j / 10;
        }

        return sum;
    }
}
