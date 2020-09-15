package 每日一题;

import java.util.Arrays;

/**
 * Description:
 *  一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 *  求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * Solution:
 *   j(n-1) = J(n-2) + j(n-3) + ... + J(1);
 *   J(n)   = J(n-1) + J(n-2) + ... + J(1);
 *   ==>
 *   J(n) = J(n-1) * 2;
 *
 *   注意与 leetcode 70题 区别
 */
public class 变态跳台阶 {
    public int JumpFloorII(int target) {
        if (target == 1) {
            return 1;
        } else {
            return JumpFloorII(target - 1) * 2;
        }
    }
}
