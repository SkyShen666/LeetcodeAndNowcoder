package 树;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;

/**
 * 思路： 利用 BFS 进行层次遍历，记录下每层的最后一个元素。
 * 时间复杂度： O(N)，每个节点都入队出队了 1 次。
 * 空间复杂度： O(N)，使用了额外的队列空间。
 *
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view/solution/jian-dan-bfsdfs-bi-xu-miao-dong-by-sweetiee/
 */
public class No_199二叉树的右视图 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.add(root.val);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
                if (i == size - 1) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }
}
