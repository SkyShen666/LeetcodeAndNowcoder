package 树;

public class No_701二叉搜索树中的插入操作 {
    // 迭代解法
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode cur = root;
        while(true) {
            if (cur.val > val) {
                if (cur.left == null) {
                    cur.left = new TreeNode(val);
                    break;
                }
                cur = cur.left;
            } else {
                if (cur.right == null) {
                    cur.right = new TreeNode(val);
                    break;
                }
                cur = cur.right;
            }
        }
        return root;
    }
    // 递归解法
//    public TreeNode insertIntoBST(TreeNode root, int val) {
//        if (root == null) {
//            return new TreeNode(val);
//        }
//        if (root.val < val) {
//            root.right = insertIntoBST(root.right, val);
//        } else {
//            root.left = insertIntoBST(root.left, val);
//        }
//        return root;
//    }
}
