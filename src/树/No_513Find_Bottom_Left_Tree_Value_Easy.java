package 树;

import java.util.LinkedList;
import java.util.Queue;

public class No_513Find_Bottom_Left_Tree_Value_Easy {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (! queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null) {
                queue.add(root.right);
            }
            if (root.left != null) {
                queue.add(root.left);
            }
        }
        return root.val;
    }



    /*public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> ret = new LinkedList<>();
        queue.add(root);
        ret.add(root);
        while (! queue.isEmpty()) {
            int levelNodeNum =queue.size();
            int flag = 1;
            for (int i = 0; i < levelNodeNum; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    flag = 0;
                    queue.add(node.left);
                    ret.add(node.left);
                }
                if (node.right != null) {
                    flag = 0;
                    queue.add(node.right);
                    ret.add(node.right);
                }
            }
            if (flag == 0) {
                while (levelNodeNum != 0) {
                    ret.poll();
                    levelNodeNum--;
                }
            }
        }
        return ret.peek().val;
    }*/
}
