package 树;

/**
 * 参考了甜姨的题解
 * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/solution/2-de-cha-ru-by-sweetiee/
 */
public class No_700二叉搜索树中的搜索 {
    // 迭代解法：
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return root;
        }

        TreeNode cur = root;
        while(true) {
            if (cur.val == val) {
                return cur;
            } else if (cur.val > val) {
                if (cur.left == null) {
                    return null;
                }
                cur = cur.left;
            } else {
                if (cur.right == null) {
                    return null;
                }
                cur = cur.right;
            }
        }
    }

    // 递归解法：
//    public TreeNode searchBST(TreeNode root, int val) {
//        if (root == null) {
//            return root;
//        }
//
//        if (root.val == val) {
//            return root;
//        }else if (root.val < val) {
//            return searchBST(root.right, val);
//        } else {
//            return searchBST(root.left, val);
//        }
//    }
}
