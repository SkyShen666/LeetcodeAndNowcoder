package 每日一题;

import java.util.*;

/**
 *
 *  如果5张牌是顺子，则一定符合条件：
 *      1、无重复的牌(大小王除外)
 *      2、max - min < 5 (大小王除外)
 *  可将问题转化为：此 5 张牌是否满足以上两个条件？
 *  参考题解：
 *  https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/solution/mian-shi-ti-61-bu-ke-pai-zhong-de-shun-zi-ji-he-se/
 */
public class 剑指61_扑克牌顺子 {
    public boolean isStraight(int[] nums) {
        if (nums == null || nums.length < 5) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        int min = 14, max = 0;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            // 若元素重复，直接返回false
            if (set.contains(num)) {
                return false;
            }
            set.add(num);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return max - min < 5;
    }
}
