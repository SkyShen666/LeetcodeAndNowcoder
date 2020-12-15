package 树;

import java.util.*;

/**
 * BFS(Breadth First Search)广度优先搜索
 * 借助队列实现即可，用队列暂时存储每一层的结点
 * @param root
 * @return
 */
public class No_637二叉树的层平均值 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            double sum = 0;
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            list.add(sum / n);
        }

        return list;
    }
}
