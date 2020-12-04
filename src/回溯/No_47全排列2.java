package 回溯;

import java.util.*;

/**
 * 参考题解
 * https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
 */
public class No_47全排列2 {
    private List<List<Integer>> res;
    private int[] nums;
    private int n;
    private boolean[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        n = nums.length;
        this.nums = nums;
        visited = new boolean[n];
        Deque<Integer> path = new LinkedList<>();
        // 剪枝前的关键一步
        Arrays.sort(nums);

        dfs(0, path);

        return res;
    }

    private void dfs(int begin, Deque<Integer> path) {
        if (begin == n) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 剪枝
        // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
        // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }

            path.addLast(nums[i]);
            visited[i] = true;
            dfs(begin + 1, path);
            visited[i] = false;
            path.removeLast();
        }
    }
}