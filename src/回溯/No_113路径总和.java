package 回溯;
import java.util.*;
public class No_113路径总和 {
    private List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<Integer> path = new LinkedList<>();

        dfs(sum, root, path);

        return res;
    }

    private void dfs(int currSum, TreeNode root, Deque<Integer> path) {
        if (root == null) {
            return;
        }

        path.addLast(root.val);
        if (currSum == root.val && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
            // 注意，这里若是加了return,本次递归下面的remove操作就不会执行
            // 这样remove操作就少执行一次
            // return; 不要加！！！！
        }
        dfs(currSum - root.val, root.left, path);
        dfs(currSum - root.val, root.right, path);
        path.removeLast();
    }
}
