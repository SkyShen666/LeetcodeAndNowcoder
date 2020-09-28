package 树;
import java.util.*;
public class No_117填充每个节点的下一个右侧节点指针2 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.remove();
                if (size - 1 > i) {
                    node.next = queue.peek();
                }
                if (size - 1 == 0) {
                    node.next = null;
                }

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
