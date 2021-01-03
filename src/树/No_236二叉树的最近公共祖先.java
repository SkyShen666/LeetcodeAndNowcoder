package 树;

/**
 * 参考题解：
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-hou-xu/
 * 最近公共祖先：需要先知道左右子树的情况，然后决定向上返回什么
 * 因此「后序遍历」的思想是很关键。
 *
 * 注意与235题的区别: 235题是二叉搜索树的最近公共祖先，此题为二叉树！
 */
public class No_236二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
