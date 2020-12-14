package 回溯;

import java.util.*;

public class No_39组合总和 {
    private List<List<Integer>> list;
    private int[] candidates;
    private int n;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        list = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return list;
        }

        this.candidates = candidates;
        n = candidates.length;
        Arrays.sort(candidates);
        Deque<Integer> path = new LinkedList<>();

        dfs(0, target, path);

        return list;
    }

    private void dfs(int begin, int target, Deque<Integer> path) {
        if (target == 0) {
            list.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < n; i++) {
            if (target - candidates[i] < 0) {
                break;
            }

            path.addLast(candidates[i]);
            dfs(i, target - candidates[i], path);
            path.removeLast();
        }
    }
}
