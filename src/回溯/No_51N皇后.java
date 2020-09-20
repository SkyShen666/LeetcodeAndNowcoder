package 回溯;
import java.util.*;

/**
 * 参考题解：
 * https://leetcode-cn.com/problems/n-queens/solution/gen-ju-di-46-ti-quan-pai-lie-de-hui-su-suan-fa-si-/
 */
public class No_51N皇后 {
    private Set<Integer> col;
    private Set<Integer> sub;
    private Set<Integer> main;
    private int n;
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        col = new HashSet<>();
        sub = new HashSet<>();
        main = new HashSet<>();

        Deque<Integer> path = new ArrayDeque<>();
        dfs(0, path);
        return res;
    }

    private void dfs(int row, Deque<Integer> path) {
        if (row == n) {
            List<String> board = convert2board(path);
            res.add(board);
            return;
        }

        // 针对行号为row的每一列，进行遍历
        for (int i = 0; i < n; i++) {
            if (!col.contains(i) && !sub.contains(row + i) && !main.contains(row - i)) {
                path.addLast(i);
                col.add(i);
                sub.add(row + i);
                main.add(row - i);

                dfs(row + 1, path);

                main.remove(row - i);
                sub.remove(row + i);
                col.remove(i);
                path.removeLast();
            }
        }
    }

    private List<String> convert2board(Deque<Integer> path) {
        List<String> board = new ArrayList<>();
        for (Integer num : path) {
            StringBuilder row = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i == num) {
                    row.append("Q");
                } else {
                    row.append(".");
                }
            }
            board.add(row.toString());
        }
        return board;
    }
}
