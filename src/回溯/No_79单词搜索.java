package 回溯;

public class No_79单词搜索 {
    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {1, -1, 0, 0};
    private char[][] board;
    private int m;
    private int n;
    private String word;
    private int wordLen;
    private boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        wordLen = word.length();
        if (wordLen == 0) {
            return false;
        }

        m = board.length;
        if (m == 0) {
            return false;
        }
        n = board[0].length;
        if (n == 0) {
            return false;
        }

        this.word = word;
        this.board = board;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int i, int j, int begin) {
        if (begin == wordLen - 1) {
            return word.charAt(begin) == board[i][j];
        }

        if (board[i][j] == word.charAt(begin)) {
            visited[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int nextX = i + dx[k];
                int nextY = j + dy[k];
                // 满足条件：1、不越界 2、未曾访问
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited[nextX][nextY]) {
                    if (dfs(nextX, nextY, begin + 1)) {
                        return true;
                    }
                }
            }
            // 回溯
            visited[i][j] = false;
        }
        return false;
    }
}
