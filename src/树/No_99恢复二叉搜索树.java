package 树;
import java.util.*;
// morris遍历算法
//https://leetcode-cn.com/problems/recover-binary-search-tree/solution/yi-wen-zhang-wo-morrisbian-li-suan-fa-by-a-fei-8/
public class No_99恢复二叉搜索树 {

}
/**
 * 方法一：暴力法
 *      中序遍历，通过ArrayList存储中序序列，然后Collections.sort排序
 *      再中序遍历把list中的值依次填回树中。
*/
//    private List<Integer> list;
//    private int index;
//
//    public void recoverTree(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        list = new ArrayList<>();
//        index = 0;
//        inorderTraverse(root);
//        Collections.sort(list);
//        buildBST(root);
//    }
//
//    private void inorderTraverse(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//
//        inorderTraverse(root.left);
//        list.add(root.val);
//        inorderTraverse(root.right);
//    }
//
//    private void buildBST(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        buildBST(root.left);
//        root.val = list.get(index);
//        index++;
//        buildBST(root.right);
//    }