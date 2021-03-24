public class practice321 {
    private int toZero(int n) {
        if (n < 3) {
            return n;
        }
        if (n == 3) {
            return 2;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;
        for (int i = 4; i <= n; i++) {
            if (i % 2 == 0 && i % 3 == 0) {
                dp[i] = Math.min(dp[i - 1], Math.min(dp[i / 2], dp[i / 3])) + 1;
            } else if (i % 2 == 0) {
                dp[i] = Math.min(dp[i - 1], dp[i / 2]) + 1;
            } else if (i % 3 == 0) {
                dp[i] = Math.min(dp[i - 1], dp[i / 3]) + 1;
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        practice321 A = new practice321();
        int num = A.toZero(11);
        System.out.println(num);
    }
}
