package 贪心思想;

import java.util.Arrays;

//贪心思想：保证每次操作都是局部最优的，并且最后得到的结果是全局最优的。
public class No_455分发饼干 {
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || g.length == 0 || s == null || s.length == 0) {
            return 0;
        }

        Arrays.sort(g);
        Arrays.sort(s);
        int max = 0;
        int i = 0, j = 0;

        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++;
                j++;
                max++;
            } else {
                j++;
            }
        }

        return max;
    }
}
