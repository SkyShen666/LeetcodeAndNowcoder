package 回溯;
import java.util.*;
public class No_90子集2 {
    private List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        int n = nums.length;
        if (n == 0) {
            return res;
        }
        // 排序
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, path);
        return res;
    }

    private void dfs(int[] nums, int begin, List<Integer> path) {
        res.add(new ArrayList<>(path));
        for (int i = begin; i < nums.length; i++) {
            // 剪枝
            if (i > begin && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            dfs(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
