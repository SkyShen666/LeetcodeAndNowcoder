package 树;

public class No_437Path_Sum_III_Easy {
    public static void main(String[] args) {

    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int count = pathStartWithRoot(root,sum) + pathSum(root.left,sum) + pathSum(root.right,sum);
        return count;
    }

    private int pathStartWithRoot(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (sum == root.val) {
            count++;
        }
        count = count + pathStartWithRoot(root.left, sum - root.val) + pathStartWithRoot(root.right, sum - root.val);
        return count;
    }
}
