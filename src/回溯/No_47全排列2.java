package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 参考题解
 * https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
 */
public class No_47全排列2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if(n == 0) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[n];
        // 剪枝前的关键一步
        Arrays.sort(nums);
        dfs(nums, n, 0, used, path, res);
        return res;
    }

    private void dfs(int[] nums, int n, int depth, boolean[] used, List<Integer> path, List<List<Integer>> res) {
        if (depth == n) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }
            // 剪枝叶
            if(i > 0 && nums[i] == nums[i - 1] && used[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            used[i] = true;
            // 回溯
            dfs(nums, n, depth + 1, used, path, res);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
