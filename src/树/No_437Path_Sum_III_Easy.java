package 树;
import java.util.*;

// 前缀和 + 回溯
// 参考题解：
// https://leetcode-cn.com/problems/path-sum-iii/solution/qian-zhui-he-di-gui-hui-su-by-shi-huo-de-xia-tian/
// https://leetcode-cn.com/problems/path-sum-iii/solution/liang-chong-fang-fa-jian-dan-yi-dong-ban-ben-by-a3/
public class No_437Path_Sum_III_Easy {
    private int sum;

    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);
        this.sum = sum;

        return dfs(root, prefixSumCount, 0);
    }

    private int dfs(TreeNode root, Map<Integer, Integer> map, int currSum) {
        if (root == null) {
            return 0;
        }

        int cnt = 0;
        currSum = currSum + root.val;
        cnt = cnt + map.getOrDefault(currSum - sum, 0);
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        cnt = cnt + dfs(root.left, map, currSum) + dfs(root.right, map, currSum);
        map.put(currSum, map.get(currSum) - 1);

        return cnt;
    }
}

//    双递归（纯暴力）时间复杂度O(n^2)
//    public int pathSum(TreeNode root, int sum) {
//        if (root == null) {
//            return 0;
//        }
//
//        return pathStartWithRoot(sum, root) + pathSum(root.left, sum) + pathSum(root.right, sum);
//    }
//
//    private int pathStartWithRoot(int currSum, TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        int cnt = 0;
//        if (currSum == root.val) {
//            cnt++;
//        }
//        cnt = cnt + pathStartWithRoot(currSum - root.val, root.left) + pathStartWithRoot(currSum - root.val, root.right);
//
//        return cnt;
//    }