package 每日一题;

import java.util.Arrays;

public class 把数组排成最小的数 {
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

        String ret = "";
        for (String str : strs) {
            ret += str;
        }

        return ret;
    }
}
