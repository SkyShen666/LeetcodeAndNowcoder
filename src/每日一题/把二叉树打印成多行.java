package 每日一题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class 把二叉树打印成多行 {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
            ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
            if (pRoot == null)
                return ret;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(pRoot);
            while (!queue.isEmpty()) {
                int cnt = queue.size();
                ArrayList<Integer> list = new ArrayList<>();
                while (cnt-- > 0) {
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
                ret.add(list);
            }
            return ret;
    }
}
