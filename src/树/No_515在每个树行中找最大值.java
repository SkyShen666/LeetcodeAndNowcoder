package 树;

import java.util.*;
public class No_515在每个树行中找最大值 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> pq = new LinkedList<>();
        pq.offer(root);
        while (pq.size() > 0) {
            int max = Integer.MIN_VALUE;
            int size = pq.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = pq.poll();
                max = Math.max(max, node.val);
                if (node.left != null) {
                    pq.offer(node.left);
                }
                if (node.right != null) {
                    pq.offer(node.right);
                }
            }
            list.add(max);
        }
        return list;
    }
}
