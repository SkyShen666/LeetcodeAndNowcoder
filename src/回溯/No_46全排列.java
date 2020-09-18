package 回溯;

import java.util.ArrayList;
import java.util.List;

public class No_46全排列 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[len];
        dfs(nums, len, 0, res, path, used);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, List<List<Integer>> res, List<Integer> path, boolean[] used) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, len, depth + 1, res, path, used);
                // 回溯
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
}
