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
    private int count = 0;
    private int val = 0;
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            count++;
            if (count == k) {
                val = node.val;
                break;
            }
            cur = node.right;
        }
        return val;
    }


    /**
     * 方法二：
     *      暴力解法：中序递归遍历的优化
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
