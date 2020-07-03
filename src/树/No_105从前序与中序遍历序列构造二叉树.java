package 树;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 */
import java.util.*;
public class No_105从前序与中序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        for(int i = 0; i < inorder.length; i++) {
            if(inorder[i] == root.val) {
                root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1),
                                        Arrays.copyOfRange(inorder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length),
                                        Arrays.copyOfRange(inorder, i + 1, inorder.length));
            }
        }
        return root;
    }
}
