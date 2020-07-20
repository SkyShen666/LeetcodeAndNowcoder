package 哈希表;

import java.util.*;
public class No_128最长连续序列 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 0;
        for (int num : set) {
            // 找到当前序列最小值
            if (!set.contains(num - 1)) {
                int currentLength = 1;
                int currentNum = num;
                while (set.contains(currentNum + 1)) {
                    currentLength += 1;
                    currentNum += 1;
                }
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }
}
