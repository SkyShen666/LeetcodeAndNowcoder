package 树;

public class No_108Convert_Sorted_Array_to_Binary_Search_Tree_Easy {
    public TreeNode sortedArrayToBST(int[] nums) {
        return partition(nums, 0, nums.length - 1);
    }

    private TreeNode partition(int nums[], int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = (high + low) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = partition(nums, low, mid -1);
        root.right = partition(nums, mid + 1, high);
        return root;
    }
}
