package 每日一题;

import java.util.*;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印
 * 使用队列进行层次遍历
 */
public class 剑指32_1从上到下打印二叉树 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }

        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        
        return ret;
    }
}
