package 树;
import java.util.*;

public class No_99恢复二叉搜索树 {

}
/**
 * 方法一：暴力法
 *      中序遍历，通过ArrayList存储中序序列，然后Collections.sort排序
 *      ，再中序遍历把list中的值依次填回树中。
 * private List<Integer> nodes = new ArrayList<>();
 *     int index = 0;
 *     public void recoverTree(TreeNode root) {
 *         if (root == null) {
 *             return;
 *         }
 *         inorderTraversal(root);
 *         Collections.sort(nodes);
 *         rebuildTree(root);
 *     }
 *
 *     private void rebuildTree(TreeNode root) {
 *         if (root != null) {
 *             rebuildTree(root.left);
 *             root.val = nodes.get(index++);
 *             rebuildTree(root.right);
 *         }
 *     }
 *
 *     private void inorderTraversal(TreeNode root) {
 *         if (root != null) {
 *             inorderTraversal(root.left);
 *             nodes.add(root.val);
 *             inorderTraversal(root.right);
 *         }
 *     }
 */