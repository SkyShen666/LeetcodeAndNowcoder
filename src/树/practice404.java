package 树;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class practice404 {
    public static TreeNode solve(TreeNode root) {
        if (root == null) {
            return root;
        }

        Deque<TreeNode> list = new LinkedList<>();
        list.addLast(root);
        while (!list.isEmpty()) {
            int n = list.size();
            int flag = 1;
            Deque<TreeNode> path = new LinkedList<>();
            // 先保存这一层的节点
            for (int i = 0; i < n; i++) {
                TreeNode node = list.pollLast();
                path.addLast(node);
                if (node.right == null || node.left == null) {
                    flag = 0;
                    break;
                }
                if (node.left != null) {
                    list.addFirst(node.left);
                }
                if (node.right != null) {
                    list.addFirst(node.right);
                }
            }
            // 若这一层其中有节点最右孩子有为空的
            if (flag == 0) {
                while (!path.isEmpty()) {
                    TreeNode node = path.pollLast();
                    node.left = null;
                    node.right = null;
                }
                return root;
            } else {
                while (!path.isEmpty()) {
                    TreeNode node = path.pollLast();
                }
            }
        }

        return root;
    }

    public static TreeNode createTree(Integer[] arr) {
        // 使用队列来存储每一层的非空节点，下一层的数目要比上一层高
        ArrayDeque<TreeNode> pre = new ArrayDeque<>();
        TreeNode root = new TreeNode(arr[0]);
        pre.addLast(root);
        // 表示要遍历的下一个节点
        int index = 0;
        while (!pre.isEmpty()) {
            ArrayDeque<TreeNode> cur = new ArrayDeque<>();
            while (!pre.isEmpty()) {
                TreeNode node = pre.removeFirst();
                TreeNode left = null;
                TreeNode right = null;
                // 如果对应索引上的数组不为空的话就创建一个节点,进行判断的时候，
                // 要先索引看是否已经超过数组的长度，如果索引已经超过了数组的长度，那么剩下节点的左右子节点就都是空了
                // 这里index每次都会增加，实际上是不必要的，但是这样写比较简单
                if (++index < arr.length && arr[index] != null) {
                    left = new TreeNode(arr[index]);
                    cur.addLast(left);
                }
                if (++index < arr.length && arr[index] != null) {
                    right = new TreeNode(arr[index]);
                    cur.addLast(right);
                }
                node.left = left;
                node.right = right;
            }
            pre = cur;
        }


        return root;
    }

    private static void prePrinTree(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        prePrinTree(node.left);
        prePrinTree(node.right);
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        TreeNode root = createTree(arr);
        solve(root);
        prePrinTree(root);
    }
}
