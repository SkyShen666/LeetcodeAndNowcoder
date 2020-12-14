package 回溯;
import java.util.*;
public class No_77组合 {
    private List<List<Integer>> list;
    private int n;
    private int k;

    public List<List<Integer>> combine(int n, int k) {
        list = new ArrayList<>();
        if (n < k || n == 0 || k == 0) {
            return list;
        }

        this.n = n;
        this.k = k;
        Deque<Integer> path = new LinkedList<>();

        dfs(1, path);

        return list;
    }

    private void dfs(int begin, Deque<Integer> path) {
        if (path.size() == k) {
            list.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i <= n; i++) {
            path.addLast(i);
            dfs(i + 1, path);
            path.removeLast();
        }
    }
}
