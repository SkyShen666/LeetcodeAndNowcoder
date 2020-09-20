package 回溯;

import java.util.ArrayList;
import java.util.List;

public class No_78子集 {
    private List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        int n = nums.length;
        if (n == 0) {
            return res;
        }
        List<Integer> pre = new ArrayList<>();
        find(nums, 0, pre);
        return res;
    }

    private void find(int[] nums, int begin, List<Integer> pre) {
        res.add(new ArrayList<>(pre));
        for (int i = begin; i < nums.length; i++) {
            pre.add(nums[i]);
            find(nums, i + 1, pre);
            pre.remove(pre.size() - 1);
        }
    }
}
