package 每日一题;

public class 剑指27_二叉树的镜像 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        swap(root);
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

    private void swap(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
}
