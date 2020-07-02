package 每日一题;

/**
 * Description:
 *  一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 *  求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * Solution:
 *  J(1) = 1;
 *  j(2) = 2;
 *  J(n) = J(n-1) + J(n-2)  n>2
 */
public class 跳台阶 {
    public int JumpFloor(int target) {
        if (target <= 2) {
            return target;
        }
        int pre1 = 1, pre2 = 2;
        int jump = 0;
        for (int i = 3; i <= target; i++) {
            jump = pre1 + pre2;
            pre1 = pre2;
            pre2 = jump;
        }
        return jump;
    }
}
