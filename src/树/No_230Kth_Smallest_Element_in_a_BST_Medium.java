package 树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No_230Kth_Smallest_Element_in_a_BST_Medium {
    /**
     * 方法三：
     *      中序非递归遍历法
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        int retValue = 0;
        TreeNode curNode = root;
        while (curNode != null || !stack.isEmpty()) {
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            curNode = stack.pop();
            count++;
            if (count == k) {
                retValue = curNode.val;
                break;
            }
            curNode = curNode.right;
        }
        return retValue;
    }


    /**
     * 方法二：
     *      暴力解法：中序递归遍历的优化
     *      剪枝处理
     * @param root
     * @param k
     * @return
    public int kthSmallest(TreeNode root, int k) {
        int leftCount = count(root.left);
        if (leftCount == k - 1) {
            return root.val;
        }else if (leftCount > k - 1) {
            return kthSmallest(root.left, k);
        }else {
            return kthSmallest(root.right, k - leftCount - 1);
        }
    }

    private int count(TreeNode root) {
       if (root == null) {
           return 0;
       }
       return 1 + count(root.left) + count(root.right);
    }

     */


/*
 *方法一：
 *暴力解法：中序递归遍历
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        InorderTraversal(root, list);
        return list.get(k-1);
    }

    private void InorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        InorderTraversal(root.left, list);
        list.add(root.val);
        InorderTraversal(root.right, list);
    }*/
}
