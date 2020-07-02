package 树;

import java.util.ArrayList;
import java.util.List;

public class No_653Two_Sum_IV_Input_is_a_BST_Easy {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        InOrderTraversal(root, nums);
        int p = 0, q = nums.size() - 1;
        while (p < q) {
            int sum = nums.get(p) + nums.get(q);
            if (sum == k) {
                return true;
            }else if (sum < k) {
                p++;
            }else {
                q--;
            }
        }
        return false;
    }

    private void InOrderTraversal(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return ;
        }
        InOrderTraversal(root.left, nums);
        nums.add(root.val);
        InOrderTraversal(root.right, nums);
    }

}
