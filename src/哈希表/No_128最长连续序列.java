package 哈希表;
import java.util.*;
// 哈希表法
// 参考题解
// https://leetcode-cn.com/problems/longest-consecutive-sequence/solution/zui-chang-lian-xu-xu-lie-by-leetcode-solution/
// 注意时间复杂度的分析：O(n)
public class No_128最长连续序列 {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = 0;
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currNum = num;
                int currLen = 1;
                while (set.contains(currNum + 1)) {
                    currNum++;
                    currLen++;
                }
                max = Math.max(max, currLen);
            }
        }

        return max;
    }
}
