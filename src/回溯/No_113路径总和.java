package 回溯;
import java.util.*;
public class No_113路径总和 {
    private List<List<Integer>> res;
    private int sum;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        this.sum = sum;
        Deque<Integer> path = new ArrayDeque<>();
        dfs(root, path, sum);
        return res;
    }

    private void dfs(TreeNode root, Deque<Integer> path, int currSum) {
        if (root == null) {
            return;
        }

        path.addLast(root.val);
        if (root.left == null && root.right == null && currSum == root.val) {
            res.add(new ArrayList<>(path));
            // 注意，这里若是加了return,下面的remove操作就不会执行
            // 这样remove操作就少执行一次
        }
        dfs(root.left, path, currSum - root.val);
        dfs(root.right, path, currSum - root.val);
        path.removeLast();
    }
}
