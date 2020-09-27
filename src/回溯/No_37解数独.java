package 回溯;
import java.util.*;
public class No_37解数独 {
    // i：第i行，j：数字digit = j+1
    private boolean[][] row = new boolean[9][9];
    private boolean[][] col = new boolean[9][9];
    private boolean[][][] block = new boolean[3][3][9];
    private boolean valid = false;
    // 存储空白格位置
    private List<int[]> spaces = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                } else {
                    int digit = board[i][j] - '0' - 1;
                    row[i][digit] = col[j][digit] = block[i / 3][j / 3][digit] = true;
                }
            }
        }
        dfs(board, 0);
    }

    private void dfs(char[][] board, int begin) {
        if (begin == spaces.size()) {
            valid = true;
            return;
        }

        int[] space = spaces.get(begin);
        int i = space[0], j = space[1];
        for (int digit = 0; digit < 9 && !valid; digit++) {
            if (!row[i][digit] && !col[j][digit] && !block[i / 3][j / 3][digit]) {
                row[i][digit] = col[j][digit] = block[i / 3][j / 3][digit] = true;
                board[i][j] = (char)(digit + '0' + 1);
                dfs(board, begin + 1);
                row[i][digit] = col[j][digit] = block[i / 3][j / 3][digit] = false;
            }
        }
    }
}
