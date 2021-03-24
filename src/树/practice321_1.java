package 树;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class practice321_1 {
    private boolean searchNode(TreeNode root, Deque<Integer> s, int nodeVal) {
        if (root == null) {
            return false;
        }

        s.push(root.val);
        if (root.val == nodeVal) {
            return true;
        }
        boolean b = false;
        if (root.left != null) {
            b = searchNode(root.left, s, nodeVal);
        }
        if (!b && root.right != null) {
            b = searchNode(root.right, s, nodeVal);
        }
        if (!b) {
            s.pop();
        }
        return b;
    }

    private List<List<Integer>> solve(TreeNode root, int[] b) {
        // ListNode[] ret = new ListNode[b.length];
        List<List<Integer>> ret = new LinkedList<>();
        for (int i = 0; i < b.length; i++) {
            Deque<Integer> stack = new LinkedList<>();
            searchNode(root, stack, b[i]);
            List<Integer> path = new LinkedList<>();
            while (!stack.isEmpty()) {
                path.add(stack.pop());
            }
            ret.add(path);
        }

        return ret;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(list);
    }
}
