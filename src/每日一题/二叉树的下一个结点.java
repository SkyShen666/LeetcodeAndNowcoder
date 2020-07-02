package 每日一题;


/**
 public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null; //指向父节点的指针

     TreeLinkNode(int val) {
        this.val = val;
     }
 }
 *
 * 给定一个二叉树和其中的一个结点，
 * 请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * 解题思路：
 *      1、若一个结点的右子树不为空，则找到此右子树的最左结点
 *      2、若一个结点的右子树为空，则向上找到第一个包含该结点的祖先结点
 */
public class 二叉树的下一个结点 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            while (pNode.next != null) {
                TreeLinkNode parent = pNode.next;
                if (parent.left == pNode) {
                    return parent;
                }
                pNode = parent;
            }
        }
        return null;
    }
}
