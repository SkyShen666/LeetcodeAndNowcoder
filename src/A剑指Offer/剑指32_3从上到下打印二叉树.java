package A剑指Offer;

import java.util.*;

/**
 * 层序遍历 + 双端队列
 * 参考题解：
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/solution/mian-shi-ti-32-iii-cong-shang-dao-xia-da-yin-er--3/
 */
public class 剑指32_3从上到下打印二叉树 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            LinkedList<Integer> path = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (ret.size() % 2 == 0) { // 偶数层 -> 队列头部
                    path.addLast(node.val);
                } else { // 奇数层 -> 队列尾部
                    path.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            ret.add(path);
        }

        return ret;
    }
}
