package 树;

import java.util.ArrayList;
import java.util.List;

public class No_530Minimum_Absolute_Difference_in_BST_Easy {
    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        List<Integer> nums = new ArrayList<>();
        InOrderTraversal(root, nums);
        for (int i = 1; i < nums.size(); i++) {
            min = min > Math.abs(nums.get(i) - nums.get(i - 1)) ? Math.abs(nums.get(i) - nums.get(i - 1)) : min;
        }
        return min;
    }

    private void InOrderTraversal(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        InOrderTraversal(root.left, nums);
        nums.add(root.val);
        InOrderTraversal(root.right, nums);
    }

}
