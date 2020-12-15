package 树;

/**
 * 自底向上
 * 思路是对二叉树做先序遍历，从底至顶返回子树最大高度，若判定某子树不是平衡树则 “剪枝” ，直接向上返回。
 * <p>
 * 算法流程：
 * recursion(root):
 * <p>
 * 递归返回值：
 * 当节点root 左 / 右子树的高度差 < 2 ：
 *      则返回以节点root为根节点的子树的最大高度，即节点 root 的左右子树中最大高度加 1（ max(left, right) + 1 ）；
 * 当节点root 左 / 右子树的高度差 ≥2 ：
 *      则返回 -1 ，代表此子树不是平衡树 。
 * <p>
 * 递归终止条件：
 *      当越过叶子节点时，返回高度 0；
 * 当左（右）子树高度 left== -1 时，代表此子树的 左（右）子树 不是平衡树，因此直接返回 -1；
 * isBalanced(root) ：
 * <p>
 * 返回值： 若 recur(root) != 1 ，则说明此树平衡，返回 true； 否则返回false 。
 * <p>
 * 复杂度分析：
 * 时间复杂度 O(N)： N为树的节点数；最差情况下，需要递归遍历树的所有节点。
 * 空间复杂度 O(N)： 最差情况下（树退化为链表时），系统递归需要使用 O(N)的栈空间。
 */
public class No_110平衡二叉树 {

    public boolean isBalanced(TreeNode root) {
        return recursion(root) != -1;
    }

    private int recursion(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = recursion(root.left);
        if (left == -1) {
            return -1;
        }
        int right = recursion(root.right);
        if (right == -1) {
            return -1;
        }

        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}

