package 树;

import java.util.*;

/**
 * 思路： 利用 BFS 进行层次遍历，记录下每层的最后一个元素。
 * 时间复杂度： O(N)，每个节点都入队出队了 1 次。
 * 空间复杂度： O(N)，使用了额外的队列空间。
 * <p>
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view/solution/jian-dan-bfsdfs-bi-xu-miao-dong-by-sweetiee/
 */
public class No_199二叉树的右视图 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
                if (i == n - 1) {
                    list.add(node.val);
                }
            }
        }

        return list;
    }
}
