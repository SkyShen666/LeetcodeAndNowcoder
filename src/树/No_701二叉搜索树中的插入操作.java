package 树;

public class No_701二叉搜索树中的插入操作 {
    // 迭代解法
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode currNode = root;

        while (true) {
            if (currNode.val > val) {
                if (currNode.left == null) {
                    currNode.left = new TreeNode(val);
                    break;
                }
                currNode = currNode.left;
            } else if (currNode.val < val) {
                if (currNode.right == null) {
                    currNode.right = new TreeNode(val);
                    break;
                }
                currNode = currNode.right;
            }
        }

        return root;
    }
}
// 递归解法
//
//    public TreeNode insertIntoBST(TreeNode root, int val) {
//        if (root == null) {
//            return new TreeNode(val);
//        }
//
//        if (root.val > val) {
//            root.left = insertIntoBST(root.left, val);
//        } else if (root.val < val) {
//            root.right = insertIntoBST(root.right, val);
//        }
//
//        return root;
//    }
//