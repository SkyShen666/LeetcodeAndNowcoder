package 回溯;

import java.util.*;

/**
 * 参考题解：
 * https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
 */
public class No_46全排列 {
    private List<List<Integer>> res;
    private int[] nums;
    private int n;
    private boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        // 使用一个动态数组保存所有可能的全排列
        res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        // 初始化
        this.nums = nums;
        n = nums.length;
        visited = new boolean[n];
        // 使用 Deque 是 Java 官方 Stack 类的建议
        Deque<Integer> path = new LinkedList<>();

        dfs(0, path);

        return res;
    }

    private void dfs(int begin, Deque<Integer> path) {
        if (begin == n) {
            // 注意：要new 一个新的list加入。
            res.add(new ArrayList<>(path));
            return;
        }

        // 在非叶子结点处，产生不同的分支
        // 这一操作的语义是：在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
        // 注意i的起始值 i = 0 而不是 i = begin！
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            path.addLast(nums[i]);
            visited[i] = true;
            dfs(begin + 1, path);
            // 回溯, 回溯发生在从 深层结点 回到 浅层结点 的过程，代码在形式上和递归之前是对称的
            visited[i] = false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        No_46全排列 test = new No_46全排列();
        List<List<Integer>> res = test.permute(nums);
        for (List<Integer> list : res) {
            System.out.print("[");
            for (Integer num : list) {
                System.out.print(num + ",");
            }
            System.out.print("] ");
        }
    }
}