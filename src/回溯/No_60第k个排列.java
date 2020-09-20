package 回溯;
import java.util.*;
public class No_60第k个排列 {
    private int k;
    private boolean[] used;
    // 阶乘数组
    private int[] factorial;
    public String getPermutation(int n, int k) {
        if (n == 0 || k == 0) {
            return null;
        }
        this.k = k;
        // 从1开始计算
        used = new boolean[n + 1];
        calculateFactorial(n);
        StringBuilder path = new StringBuilder();
        dfs(n, 1, path);
        return path.toString();
    }

    /**
     *
     * @param n
     * @param index 在进行这一步前，已经选了若干数字，index的值恰好等于要选的那个数字
     * @param path
     */
    private void dfs(int n, int index, StringBuilder path) {
        // 已经全部选完
        if (index == n + 1) {
            return;
        }

        // 计算还未确定的数字的全排列个数
        int cnt = factorial[n - index];
        for (int i = 1; i <= n; i++) {
            // 剪枝,已确定的跳过
            if(used[i]) {
                continue;
            }
            // 剪枝，下面的组合无需计算，可减掉。
            if(cnt < k) {
                k -= cnt;
                continue;
            }
            path.append(i);
            used[i] = true;
            dfs(n, index + 1, path);
            // 注意，这里要加return，后面的数字没必要计算了
            return;
        }
    }

    private void calculateFactorial(int n) {
        // 从1开始计算
        factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }
}
