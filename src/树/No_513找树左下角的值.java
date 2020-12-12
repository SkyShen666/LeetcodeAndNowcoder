package 树;
import java.util.LinkedList;
import java.util.Queue;
// 层序遍历：（从右至左）
// 参考题解：
// https://leetcode-cn.com/problems/find-bottom-left-tree-value/solution/cong-you-dao-zuo-de-ceng-xu-bian-li-bu-xu-ji-lu-zh/
// 一般的层序遍历是每层从左到右，遍历到最后的元素就是右下角元素。
// 如果反过来，每层从右到左进行层序遍历，最后一个就是左下角元素，直接输出即可，不需要记录深度。
public class No_513找树左下角的值 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode currNode = root;
        queue.offer(currNode);

        while (!queue.isEmpty()) {
            currNode = queue.poll();

            if (currNode.right != null) {
                queue.offer(currNode.right);
            }
            if (currNode.left != null) {
                queue.offer(currNode.left);
            }
        }

        return currNode.val;
    }
}


//    正常的层序遍历
//
//    public int findBottomLeftValue(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        TreeNode currNode = root;
//        queue.offer(currNode);
//
//        while (!queue.isEmpty()) {
//            int n = queue.size();
//            currNode = queue.peek();
//            for (int i = 0; i < n; i++) {
//                TreeNode node = queue.poll();
//                if (node.left != null) {
//                    queue.offer(node.left);
//                }
//                if (node.right != null) {
//                    queue.offer(node.right);
//                }
//            }
//        }
//
//        return currNode.val;
//    }
