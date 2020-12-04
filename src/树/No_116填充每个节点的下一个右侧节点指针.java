package 树;
import java.util.*;
// 参考题解：
// https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/solution/dong-hua-yan-shi-san-chong-shi-xian-116-tian-chong/
public class No_116填充每个节点的下一个右侧节点指针 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        // bfs
        while (queue.size() > 0) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node node = queue.poll();
                node.next = i == (n - 1) ? null : queue.peek();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return root;
    }
}
