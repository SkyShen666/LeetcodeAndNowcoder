package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 参考题解：
 * https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
 */
public class No_46全排列 {
    public List<List<Integer>> permute(int[] nums) {
        // 使用一个动态数组保存所有可能的全排列
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
            // 注意：要new 一个新的list加入。
            res.add(new ArrayList<>(path));
            return;
        }
        // 在非叶子结点处，产生不同的分支，这一操作的语义是：在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, len, depth + 1, res, path, used);
                // 回溯, 回溯发生在从 深层结点 回到 浅层结点 的过程，代码在形式上和递归之前是对称的
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
}
