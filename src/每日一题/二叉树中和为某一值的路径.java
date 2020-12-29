package 每日一题;

import java.util.*;
/**
 * 输入一颗二叉树的根节点和一个整数，
 * 打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class 二叉树中和为某一值的路径 {
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
        }
        dfs(root.left, sum - root.val, path);
        dfs(root.right, sum - root.val, path);

        path.removeLast();
    }
}
