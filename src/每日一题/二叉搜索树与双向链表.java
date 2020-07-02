package 每日一题;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class 二叉搜索树与双向链表 {
    TreeNode head = null;
    TreeNode pre = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        InOrder(pRootOfTree);
        return head;
    }

    private void InOrder(TreeNode node) {
        if (node == null)
            return;
        InOrder(node.left);
        node.left = pre;
        if (pre != null)
            pre.right = node;
        pre = node;
        if (head == null)
            head = pre;
        InOrder(node.right);
    }
}
