package 树;

public class No_968监控二叉树 {
    public int minCameraCover(TreeNode root) {
        int[] array = dfs(root);
        return array[1];
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            // 结点为空，不能在该节点放置监控
            return new int[]{Integer.MAX_VALUE / 2, 0, 0};
        }

        int[] leftArray = dfs(root.left);
        int[] rightArray = dfs(root.right);
        int[] array = new int[3];
        array[0] = leftArray[2] + rightArray[2] + 1;
        array[1] = Math.min(array[0], Math.min(leftArray[0] + rightArray[1], leftArray[1] + rightArray[0]));
        array[2] = Math.min(array[0], leftArray[1] + rightArray[1]);

        return array;
    }
}
