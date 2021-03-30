package 树;
import java.util.*;

public class No_622二叉树最大宽度 {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> deque = new LinkedList<>(); // 存储层次遍历的树的结点
        deque.addLast(root);
        Deque<Integer> dequeIndex = new LinkedList<>(); // 存储队列中结点的下标
        dequeIndex.addLast(1);
        int max = 1;
        while (!deque.isEmpty()) {
            int n = deque.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = deque.pollFirst();
                int currIdx = dequeIndex.pollFirst();
                if (node.left != null) {
                    deque.addLast(node.left);
                    dequeIndex.addLast(2 * currIdx);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                    dequeIndex.addLast(2 * currIdx + 1);
                }
            }
            if (dequeIndex.size() >= 2) {
                max = Math.max(max, dequeIndex.peekLast() - dequeIndex.peekFirst() + 1);
            }
        }

        return max;
    }
}
