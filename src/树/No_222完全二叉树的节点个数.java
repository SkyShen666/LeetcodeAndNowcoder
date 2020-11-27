package 树;

// 参考题解：
// https://leetcode-cn.com/problems/count-complete-tree-nodes/solution/chang-gui-jie-fa-he-ji-bai-100de-javajie-fa-by-xia/
public class No_222完全二叉树的节点个数 {
/*
    // 解法1：递归，没有用到完全二叉树的性质
    private int count = 0;
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        count++;
        countNodes(root.left);
        countNodes(root.right);
        return count;
    }*/

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLevel = levelCount(root.left);
        int rightLevel = levelCount(root.right);
        if (leftLevel == rightLevel) {
            return (1 << leftLevel) + countNodes(root.right);
        } else {
            return countNodes(root.left) + (1 << rightLevel);
        }
    }

    private int levelCount(TreeNode root) {
        int level = 0;
        while (root != null) {
            level++;
            root = root.left;
        }
        return level;
    }
}
