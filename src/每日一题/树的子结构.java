package 每日一题;

import java.util.HashMap;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 结构相等包括了结点的值相等
 */
public class 树的子结构 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        boolean result  = false;
        if (root1.val == root2.val) {
            result = isSubTreeWithRoot(root1,root2);
        }
        if (!result) {
            result = HasSubtree(root1.left, root2);
        }
        if (!result) {
            result = HasSubtree(root1.right, root2);
        }
        return result;
    }

    private boolean isSubTreeWithRoot(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) { //递归出口
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSubTreeWithRoot(root1.left, root2.left) && isSubTreeWithRoot(root1.right, root2.right);
    }

}
