package 回溯;

import org.junit.Test;

public class No_130被围绕的区域 {
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private char[][] board;
    private int n;
    private int m;
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        if (board[0].length == 0) {
            return;
        }
        this.board = board;
        n = board.length;
        m = board[0].length;

        // 第一列和最后一列
        for (int i = 0; i < n; i++) {
            dfs(i, 0);
            dfs(i, m - 1);
        }

        // 第一行和最后一行
        for (int i = 1; i < m - 1; i++) {
            dfs(0, i);
            dfs(n - 1, i);
        }

        // 把所有是"N"的都换成'O'
        //   所有是"O"的都换成'X'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'N') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(int i, int j) {
        if (i >= 0 && i < n && j >= 0 && j < m && board[i][j] == 'O') {
            board[i][j] = 'N';
            for (int k = 0; k < 4; k++) {
                int nextX = i + dx[k];
                int nextY = j + dy[k];
                dfs(nextX, nextY);
            }
        }
    }

    @Test
    public void test() {
//        [["X","O"],["O","X"]]
        char[][] board = {{'X', 'O'}, {'O', 'X'}};
        solve(board);
        n = board.length;
        m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
