package 回溯;
import java.util.*;
public class No_77组合 {
    private List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        if (n < k || n == 0 || k == 0) {
            return res;
        }

        List<Integer> pre = new ArrayList<>();
        backtrack(n, k, 1, pre);
        return res;
    }

    private void backtrack(int n, int k, int begin, List<Integer> pre) {
        if (pre.size() == k) {
            res.add(new ArrayList<>(pre));
        }
        for (int i = begin; i <= n; i++) {
            pre.add(i);
            backtrack(n, k, i + 1, pre);
            pre.remove(pre.size() - 1);
        }
    }
}
