package 回溯;

public class No_79单词搜索 {
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private char[][] board;
    private boolean[][] visited;
    private String word;
    private int n;
    private int m;
    private int wordLen;
    public boolean exist(char[][] board, String word) {
        wordLen = word.length();
        if (wordLen == 0) {
            return false;
        }
        n = board.length;
        if (n == 0) {
            return false;
        }
        m = board[0].length;
        if (m == 0) {
            return false;
        }

        this.board = board;
        this.word = word;
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int begin) {
        if (begin == wordLen - 1) {
            return board[i][j] == word.charAt(begin);
        }

        if (board[i][j] == word.charAt(begin)) {
            visited[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int nextX = i + dx[k];
                int nextY = j + dy[k];
                // 满足条件：1、不越界 2、未曾访问
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && !visited[nextX][nextY]) {
                    if (dfs(nextX, nextY, begin + 1)) {
                        return true;
                    }
                }
            }
            visited[i][j] = false;
        }
        return false;
    }
}
