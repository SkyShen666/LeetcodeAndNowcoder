package 动态规划;

public class No_鸡蛋掉落 {
    public int superEggDrop(int K, int N) {
        return dp(K , N);
    }

    private int dp(int k, int n) {
        if (k == 1)
            return n;
        if (k == 0)
            return 0;
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            res = Math.min(res,
                            Math.max(
                                    // 没碎
                                    dp(k, n - i),
                                    // 碎了
                                    dp(k - 1 , i - 1)
                            ) + 1);
        }
        return res;
    }
}
