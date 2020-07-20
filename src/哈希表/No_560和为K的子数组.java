package 哈希表;
import java.util.*;

/**
 * pre[i] = pre[i - 1] + nums[i];
 * 而 [j,i] 这个子数组和为k,可转化为
 * pre[i] - pre[j - 1] = k
 * 即pre[i] - k = pre[j - 1];
 * 所以我们考虑以 i 结尾的和为 k 的连续子数组个数时
 * 只要统计有多少个前缀和为pre[i]−k的pre[j]即可。

 */
public class No_560和为K的子数组 {
    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        // 建立pre的map集合
        Map<Integer, Integer> preMap = new HashMap<>();
        // pre = 0 出现一次
        preMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (preMap.containsKey(pre - k)) {
                count += preMap.get(pre - k);
            }
            preMap.put(pre, preMap.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
