package 回溯;
// 回溯
// 思路：通过 计算剩余数字个数的阶乘数，一位一位选出第 k 个排列的数位。
// 参考题解：
// https://leetcode-cn.com/problems/permutation-sequence/solution/hui-su-jian-zhi-python-dai-ma-java-dai-ma-by-liwei/

public class No_60第k个排列 {
    private int n;
    private int k;
    private boolean[] visited;
    private int[] factorial; // 阶乘数组

    public String getPermutation(int n, int k) {
        if (n == 0 || k == 0) {
            return null;
        }

        this.n = n;
        this.k = k;
        visited = new boolean[n + 1]; // 从1开始计算
        factorial = new int[n + 1];
        calFactorial();
        StringBuilder path = new StringBuilder();

        dfs(1, path);

        return path.toString();
    }

    /**
     * 利用了剪枝的思想，减去了大量枝叶，直接来到需要的叶子结点；
     * @param begin 在进行这一步前，已经选了若干数字，begin为已经选了begin个数字
     * @param path
     */
    private void dfs(int begin, StringBuilder path) {
        // 已经全部选完
        if (begin == n + 1) {
            return;
        }

        // 计算还未确定的数字的全排列个数
        int cnt = factorial[n - begin];

        for (int i = 1; i <= n; i++) {
            // 剪枝,已确定的跳过
            if(visited[i]) {
                continue;
            }
            // 剪枝，下面的组合无需计算，可减掉。
            if(cnt < k) {
                k = k - cnt;
                continue;
            }

            path.append(i);
            visited[i] = true;
            dfs(begin + 1, path);
            // 注意 1：不可以回溯（重置变量），算法设计是「一下子来到叶子结点」，没有回头的过程
            // 注意 2：这里要加return，后面的数字没必要计算了
            return;
        }
    }

    // 计算阶乘数组
    private void calFactorial() {
        // 从1开始计算
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }
}
