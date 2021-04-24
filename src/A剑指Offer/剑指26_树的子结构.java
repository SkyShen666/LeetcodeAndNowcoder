package A剑指Offer;

/**
 * 参考题解：
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/solution/mian-shi-ti-26-shu-de-zi-jie-gou-xian-xu-bian-li-p/
 */
public class 剑指26_树的子结构 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        }
        if (A == null || B == null) {
            return false;
        }

        boolean ret = false;
        if (A.val == B.val) {
            ret = isSubTree(A, B);
        }
        if (!ret) {
            ret = isSubStructure(A.left, B);
        }
        if (!ret) {
            ret = isSubStructure(A.right, B);
        }

        return ret;
    }

    private boolean isSubTree(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }

        return isSubTree(A.left, B.left) && isSubTree(A.right, B.right);
    }
}
