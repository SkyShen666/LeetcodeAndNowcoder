package 树;

/**
 * 二叉查找树(BST)即Binary Search Tree
 * 根节点大于等于左子树所有节点，小于等于右子树所有节点。
 * 二叉查找树中序遍历有序。
 */
public class No_669Trim_a_Binary_Search_Tree_Easy {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        if (root.val > R) {
            return trimBST(root.left, L, R);
        }
        if (root.val < L) {
            return trimBST(root.right, L, R);
        }
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
