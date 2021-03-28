package 动态规划;

import java.util.Arrays;

/**
 * 此题为：LC300最长递增子序列
 * 参考题解：
 * https://leetcode-cn.com/problems/russian-doll-envelopes/solution/zui-chang-shang-sheng-zi-xu-lie-bian-xin-6s8d/
 * 方法1： 动态规划  时间复杂度O(n^2)，时间复杂度过高
 * 方法2： 动态规划 + 二分法 时间复杂度O(n)
 */
public class No_354俄罗斯套娃信封问题 {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }

        Arrays.sort(envelopes, (o1, o2) -> o1[0] - o2[0]);
        int n = envelopes.length;
        // dp[i] 为只考虑前i个信封，并以第i个信封为结尾的最大值
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // 对于每个dp[i]，都满足最小值为 1
        // h[i]记录的是长度为i的最长上升序列的最小【信封高度】
        int[] h = new int[n];
        Arrays.fill(h, Integer.MAX_VALUE); // 因为要取min，用一个足够大的高度初始化
        h[0] = 0;
        int max = 1;
        for (int i = 0, j = 0, currLen = 1; i < n; i++) {
            // 1.
            // 对于w相同的数据，不更新h数组
            if (envelopes[i][0] != envelopes[j][0]) {
                // 限制j不能越过i，确保h数组中只会出现第i个信封前的【历史信封】
                while (j < i) {
                    int preLen = dp[j];
                    int currHigh = envelopes[j][1];
                    if (preLen == currLen) {
                        // 与当前长度一致，说明上升序列多增加一位
                        h[currLen++] = currHigh;
                    } else {
                        // 始终保留最小的「信封高度」，这样可以确保有更多的信封可以与其行程上升序列
                        // 举例：同样是上升长度为 5 的序列，保留最小高度为 5 记录（而不是保留任意的，比如 10），这样之后高度为 7 8 9 的信封都能形成序列；
                        h[preLen] = Math.min(h[preLen], currHigh);
                    }
                    j++;
                }
            }

            // 2. 二分过程
            // h[i] 代表的是上升序列长度为 i 的 【最小信封高度】
            int low = 0, high = currLen;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (h[mid] >= envelopes[i][1]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            // 3. 更新 dp[i] 与 答案
            dp[i] = low;
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}

//    方法1：
//    动态规划, 时间复杂度 O(n * n)
//    public int maxEnvelopes(int[][] envelopes) {
//        if (envelopes == null || envelopes.length == 0) {
//            return 0;
//        }
//
//        Arrays.sort(envelopes, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
//        int max = 0;
//        int n = envelopes.length;
//        //  dp[i] 为只考虑前i个信封，并以第i个信封为结尾的最大值
//        int[] dp = new int[n];
//        Arrays.fill(dp, 1); // 对于每个dp[i]，都满足最小值为 1
//        for (int i = 0; i < n; i++) {
//            for (int j = i - 1; j >= 0; j--) {
//                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//            max = Math.max(max, dp[i]);
//        }
//
//        return max;
//    }