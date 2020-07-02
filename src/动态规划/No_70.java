package 动态规划;

/**
 *递归和动态规划都是将原问题拆分成多个子问题然后求解，他们之间最本质的区别是，动态规划保存了子问题的解，避免重复计算
 */
public class No_70 {
    public static void main(String[] args) {
        int n = climbStairs(4);
        System.out.println(n);
    }

    /**
     * 优化后的动态规划
     *      dp[i]只与dp[i-2]dp[i-1]有关，只需用两个变量pre1、pre2分别代替即可，降低空间复杂度
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param n
     * @return
     */
    private static int climbStairs(int n) {
        if (n <= 2){
            return n;
        }
        int pre1 = 1, pre2 = 2;
        for (int i = 3; i <= n; i++){
            int curr = pre1 + pre2;
            pre1 = pre2;
            pre2 = curr;
        }
        return pre2;
    }


    /**
     * 解法二：动态规划
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param n
     * @return
    private static int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
     */

    /**
     * 解法一：暴力递归
     * @param n
     * @return

    private static int climbStairs(int n) {
        return climb_Stairs(0,n);
    }

    private static int climb_Stairs(int i,int n){
        if(i > n){
            return 0;
        }
        if(i == n){
            return 1;
        }
        return climb_Stairs(i + 1,n) + climb_Stairs(i + 2,n);
    }
     */
}
