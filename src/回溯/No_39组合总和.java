package 回溯;
import java.util.*;

public class No_39组合总和 {
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        if (target == 0) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, path);
        return res;
    }

    private void backtrack(int[] candidates, int target, int begin, Deque<Integer> path) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            // 剪枝
            if (target - candidates[i] < 0) {
                break;
            }

            path.addLast(candidates[i]);
            backtrack(candidates, target - candidates[i], i, path);
            path.removeLast();
        }
    }
}
