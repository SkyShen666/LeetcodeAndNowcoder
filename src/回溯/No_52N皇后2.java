package 回溯;
import java.util.*;
public class No_52N皇后2 {

    private Set<Integer> col;
    private Set<Integer> main;
    private Set<Integer> sub;
    private int n;
    private int sum;

    public int totalNQueens(int n) {
        this.n = n;
        sum = 0;
        if (n == 0) {
            return sum;
        }

        col = new HashSet<>();
        main = new HashSet<>();
        sub = new HashSet<>();


        dfs(0);
        return sum;
    }

    private void dfs(int row) {
        if (row == n) {
            sum++;
        }

        for (int i = 0; i < n; i++) {
            if (!col.contains(i) && !main.contains(row - i) && !sub.contains(row + i)) {
                col.add(i);
                main.add(row - i);
                sub.add(row + i);

                dfs(row + 1);

                sub.remove(row + i);
                main.remove(row - i);
                col.remove(i);
            }
        }
    }
}
