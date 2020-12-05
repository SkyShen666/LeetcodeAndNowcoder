package 回溯;

import java.util.*;

/**
 * 参考题解：
 * https://leetcode-cn.com/problems/n-queens/solution/gen-ju-di-46-ti-quan-pai-lie-de-hui-su-suan-fa-si-/
 */
public class No_51N皇后 {
    private List<List<String>> ret;
    private int n;
    private Set<Integer> col;  // 列，（按行进行遍历，所以不需要存储行的Set）
    private Set<Integer> main; // 主对角线
    private Set<Integer> sub;  // 副对角线

    public List<List<String>> solveNQueens(int n) {
        ret = new ArrayList<>();
        if (n == 0) {
            return ret;
        }

        this.n = n;
        col = new HashSet<>();
        main = new HashSet<>();
        sub = new HashSet<>();
        Deque<Integer> path = new LinkedList<>();

        dfs(0, path);

        return ret;
    }

    // 针对行号为begin的每一列进行遍历
    private void dfs(int begin, Deque<Integer> path) {
        if (begin == n) {
            List<String> board = convert2Board(path);
            ret.add(board);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!col.contains(i) && !main.contains(begin - i) && !sub.contains(begin + i)) {
                path.addLast(i);
                col.add(i);
                main.add(begin - i);
                sub.add(begin + i);

                dfs(begin + 1, path);

                sub.remove(begin + i);
                main.remove(begin - i);
                col.remove(i);
                path.removeLast();
            }
        }
    }

    private List<String> convert2Board(Deque<Integer> path) {
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
