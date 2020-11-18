package 动态规划;

/**
 *
 *  断"onetwothreefour"这一个字符串能不能满足条件，我们很自然的想法就是：
 * 如果"onetwothree"这一段可以拆分，再加上four如果也可以，那不就行了；
 * 或者
 * 如果"onetwothre"这一段可以拆分，再加上efour如果也可以，那不就行了；
 * 这其实已经抓住了动态规划的最核心的东西了，换成式子来表达，就是
 *
 *
 * dp["onetwothreefour"] = dp["onetwothree"这一段] && 判断一下"four"
 * dp["onetwothreefour"] = dp["onetwothre"这一段] && 判断一下"efour"
 *
 *  dp[i] = dp[j] && check(s[j, i - 1])
 *
 *  动态规划的基本操作:
 *  1、定义dp数组
 *  2、初始化
 *  3、转化公式
 *  4、搞定！
 */

import java.util.*;
public class No_139单词拆分 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        // dp[i]表示：[0, i - 1] 中的字符串，是否可以被拆分成字典中的单词。
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = dp[j] && wordDict.contains(s.substring(j, i));
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[n];
    }
}
