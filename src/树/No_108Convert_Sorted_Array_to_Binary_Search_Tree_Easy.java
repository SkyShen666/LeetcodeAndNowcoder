package 树;

/**
 * 题目分析：
 * BST的中序遍历是升序的，因此本题等同于根据中序遍历的序列恢复二叉搜索树。
 * 因此我们可以以升序序列中的任一个元素作为根节点，以该元素左边的升序序列构建左子树，
 * 以该元素右边的升序序列构建右子树，这样得到的树就是一棵二叉搜索树啦～
 * 又因为本题要求高度平衡，因此我们需要选择升序序列的中间元素作为根节点奥
 *
 * 题目扩展：
 * 109. 有序链表转换二叉搜索树 将本题的数组换成了链表，做法完全一样，
 * 不过链表无法像数组一样直接索引到中间元素，
 * 链表找中间节点可以用快慢指针法，详见 876. 链表的中间结点。
 *
 * 作者：sweetiee
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/solution/jian-dan-di-gui-bi-xu-miao-dong-by-sweetiee/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
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
