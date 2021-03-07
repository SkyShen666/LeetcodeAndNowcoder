package 每日一题;

import java.util.Arrays;

/**
 * 参考题解：
 * https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/solution/mian-shi-ti-45-ba-shu-zu-pai-cheng-zui-xiao-de-s-4/
 * 注意排序规则：(x, y) -> (x + y).compareTo(y + x)
 * x小于y，相当于x需要排在y的前面
 * 如： x = “3”  y = “30”
 *     x + y = "330"
 *     y + x = "303"
 *     即 x + y > y + x
 *     排序应该是 y 排在 x 的前面
 */
public class 剑指45_把数组排成最小的数 {
    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        int n = nums.length;
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = nums[i] + "";
        }
        /**
         * 给nums排序时，排序的规则应该是:若s1 + s2 < s2 + s1,那么s1应该排在s2前面

         Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
         */
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));

        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }

        return sb.toString();
    }
}
