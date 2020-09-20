package 回溯;
import java.util.*;
public class No_40组合总和2 {
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        List<Integer> list =  new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, list);
        return res;
    }

    private void backtrack(int[] candidates, int target, int begin, List<Integer> list) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            // i > begin 防止i = 0的情况下数组越界
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
