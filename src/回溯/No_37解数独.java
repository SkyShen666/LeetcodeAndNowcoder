package 回溯;

import java.util.*;

public class No_37解数独 {
    private boolean[][] row; // i：第i行，j：数字digit
    private boolean[][] col;
    private boolean[][][] block;
    private boolean valid;
    private List<int[]> spaces; // 存储空白格位置

    public void solveSudoku(char[][] board) {
        // j 下标从0开始，而需要存储数字1-9
        // 对应row[1][9]: 第1行，是否存储数字9
        row = new boolean[9][10];
        col = new boolean[9][10];
        block = new boolean[3][3][10];
        valid = false;
        spaces = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                } else {
                    int digit = board[i][j] - '0';
                    row[i][digit] = col[j][digit] = block[i / 3][j / 3][digit] = true;
                }
            }
        }
        dfs(board, 0);
    }

    private void dfs(char[][] board, int begin) {
        // 已经填充完
        if (begin == spaces.size()) {
            valid = true;
            return;
        }

        int[] space = spaces.get(begin);
        int i = space[0], j = space[1];
        for (int digit = 1; digit <= 9 && !valid; digit++) {
            if (!row[i][digit] && !col[j][digit] && !block[i / 3][j / 3][digit]) {
                board[i][j] = (char) (digit + '0');
                row[i][digit] = col[j][digit] = block[i / 3][j / 3][digit] = true;
                dfs(board, begin + 1);
                // 回溯
                row[i][digit] = col[j][digit] = block[i / 3][j / 3][digit] = false;
            }
        }
    }
}
