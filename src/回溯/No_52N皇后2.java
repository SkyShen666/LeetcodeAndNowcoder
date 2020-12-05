package 回溯;
import java.util.*;
public class No_52N皇后2 {
    private int cnt;
    private int n;
    private Set<Integer> col;
    private Set<Integer> main;
    private Set<Integer> sub;

    public int totalNQueens(int n) {
        if (n == 0) {
            return 0;
        }

        this.n = n;
        col = new HashSet<>();
        main = new HashSet<>();
        sub = new HashSet<>();
        cnt = 0;

        dfs(0);

        return cnt;
    }

    private void dfs(int begin) {
        if (begin == n) {
            cnt++;
            return;
        }

        // 遍历行号为begin的每一列
        for (int i = 0; i < n; i++) {
            if (!col.contains(i) && !main.contains(begin - i) && !sub.contains(begin + i)) {
                col.add(i);
                main.add(begin - i);
                sub.add(begin + i);

                dfs(begin + 1);

                sub.remove(begin + i);
                main.remove(begin - i);
                col.remove(i);
            }
        }
    }
}