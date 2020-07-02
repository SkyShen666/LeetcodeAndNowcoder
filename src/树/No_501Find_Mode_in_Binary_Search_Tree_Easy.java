package 树;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class No_501Find_Mode_in_Binary_Search_Tree_Easy {

    private int curCnt = 1;
    private int maxCnt = 0;
    private TreeNode preNode = null;

    public int[] findMode(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        InOrderTraversal(root, nums);
        int[] ret = new int[nums.size()];
        int index = 0;
        for (int num : nums) {
            ret[index++] = num;
        }
        return ret;
    }

    private void InOrderTraversal(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        InOrderTraversal(root.left, nums);
        if (preNode != null) {
            curCnt = preNode.val == root.val ? curCnt + 1 : 1;
        }
        if (curCnt > maxCnt) {
            maxCnt = curCnt;
            nums.clear();
            nums.add(root.val);
        } else if (curCnt == maxCnt){
            nums.add(root.val);
        }
        preNode = root;
        InOrderTraversal(root.right, nums);
    }
}
