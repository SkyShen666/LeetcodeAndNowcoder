package 树;
import java.util.*;
public class No_106从中序与后续遍历序列构造二叉树 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        if (n == 0) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[n - 1]);
        for (int i = 0; i < n; i++) {
            if (inorder[i] == root.val) {
                root.left = buildTree(Arrays.copyOfRange(inorder, 0, i),
                        Arrays.copyOfRange(postorder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(inorder, i + 1, n),
                        Arrays.copyOfRange(postorder, i, n - 1));
            }
        }
        return root;
    }
}
