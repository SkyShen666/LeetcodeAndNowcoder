package 每日一题;

import java.util.*;

/**
 *  约瑟夫环
 *  用 ArrayList 模拟
 *  参考题解：
 *  https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/javajie-jue-yue-se-fu-huan-wen-ti-gao-su-ni-wei-sh/
 *  注意用 ArrayList 的时间复杂度的问题
 */
public class 剑指62_圆圈中最后剩下的数字 {
    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int i = 0;
        while (n > 1) {
            i = (i + m - 1) % n;
            list.remove(i);
            n--;
        }

        return list.get(0);
    }
}
