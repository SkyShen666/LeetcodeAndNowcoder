package 回溯;

import java.util.*;

public class No_40组合总和2 {
    private List<List<Integer>> list;
    private int[] candidates;
    private int n;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            // 大剪枝
            if (target - candidates[i] < 0) {
                break;
            }
            // 小剪枝：同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.addLast(candidates[i]);
            dfs(i + 1, target - candidates[i], path);
            path.removeLast();
        }
    }
}
