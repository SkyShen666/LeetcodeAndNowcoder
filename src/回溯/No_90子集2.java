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
        Deque<Integer> path = new ArrayDeque<>();
        Arrays.sort(nums);
        backtrack(nums, 0, path);
        return res;
    }

    private void backtrack(int[] nums, int begin, Deque<Integer> path) {
        res.add(new ArrayList<>(path));
        for (int i = begin; i < nums.length; i++) {
            // 剪枝
            if (i > begin && nums[i] == nums[i - 1]) {
                continue;
            }

            path.addLast(nums[i]);
            backtrack(nums, i + 1, path);
            path.removeLast();
        }
    }
}
