package A剑指Offer;

public class 剑指12_矩阵中的路径 {
    private static final int[] di = {1, -1, 0, 0};
    private static final int[] dj = {0, 0, -1, 1};
    private char[][] board;
    private int m;
    private int n;
    private String word;
    private int len;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }

        this.board = board;
        m = board.length;
        n = board[0].length;
        this.word = word;
        len = word.length();
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (dfs(i, j, 0)) { // 若返回结果为true说明在表格中找到了字符串
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(int i, int j, int begin) {
        if (begin == len - 1) {
            return board[i][j] == word.charAt(begin);
        }

        if (board[i][j] == word.charAt(begin)) {
            visited[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int nextI = i + di[k];
                int nextJ = j + dj[k];
                if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n && !visited[nextI][nextJ]) {
                    if (dfs(nextI, nextJ, begin + 1)) {
                        return true;
                    }
                }
            }
            //每次搜索结束后都要，回溯（回退），将这一次搜索过程中设置的状态进行清除，从而开始新一次的搜索。
            visited[i][j] = false;
        }

        return false;
    }
}
