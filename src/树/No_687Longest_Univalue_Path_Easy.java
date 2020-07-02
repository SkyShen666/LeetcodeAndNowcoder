package 树;

public class No_687Longest_Univalue_Path_Easy {

    private int maxPath = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return maxPath;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int leftPath =  root.left != null && root.left.val == root.val ? left + 1 : 0;
        int rightPath = root.right != null && root.right.val == root.val ? right + 1 : 0;
        maxPath = Math.max(leftPath + rightPath, maxPath);
        return Math.max(leftPath,rightPath);
    }
}
