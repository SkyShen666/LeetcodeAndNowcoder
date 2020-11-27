package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 执行一次深度优先遍历，一条路走到底，走不通的时候，返回回来，继续执行，一直这样下去，直到回到起点。
 * 参考题解：
 * https://leetcode-cn.com/problems/subsets/solution/hui-su-python-dai-ma-by-liweiwei1419/
 */
public class No_78子集 {
    private List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        int n = nums.length;
        if (n == 0) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, path);
        return res;
    }

    private void dfs(int[] nums, int begin, List<Integer> path) {
        // 没有显式的递归终止
        // 注意：Java 的引用传递机制，这里要 new 一下
        res.add(new ArrayList<>(path));
        for (int i = begin; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1, path);
            // 组合问题，状态在递归完成后要重置
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        No_78子集 test = new No_78子集();
        List<List<Integer>> res = test.subsets(nums);
        for (List<Integer> list : res) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println("-");
        }
    }
}
