package 每日一题;

import java.util.*;

public class 剑指34_二叉树中和为某一值的路径 {
    private List<List<Integer>> list;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        list = new LinkedList<>();
        if (root == null) {
            return list;
        }

        Deque<Integer> path = new LinkedList<>();
        dfs(root, sum, path);

        return list;
    }

    private void dfs(TreeNode root, int sum, Deque<Integer> path) {
        if (root == null) {
            return;
        }

        path.addLast(root.val);
        if (sum == root.val && root.left == null && root.right == null) {
            list.add(new ArrayList<>(path));
            // 注意这里不能return，还需要进行回溯，查找其他路径。
        }
        dfs(root.left, sum - root.val, path);
        dfs(root.right, sum - root.val, path);
        // 回溯
        path.removeLast();
    }
}
