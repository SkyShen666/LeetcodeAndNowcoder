package 位运算;

import java.util.Arrays;

/**
 * Description:
 *      Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 *      find the one that is missing from the array.
 * Example1:
 *      Input: [3,0,1]
 *      Output: 2
 * Example2:
 *      Input: [9,6,4,2,3,5,7,0,1]
 *      Output: 8
 */
public class No_268Missing_Number {
    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        int n = missingNumber(nums);
        System.out.println(n);
    }

    /**
     * 异或运算(^)满足结合律，一个数字a，经过两次相同的异或运算会得到原来的数a，即：a^b^b = a;
     * 两个相同的数异或后为零：a^a = 0;
     * 从[0,,,n]中查找缺失的数，(若补上缺失的数)数组的下标亦为[0,,,n]
     * 重复两次的数，异或后皆为0，缺失的数只异或一次，则为缺失的数：0^c = c
     * =====================
     *      a:0011
     *      b:0001
     *  t=a^b:0010
     *      b:0001
     *  a=t^b:0011
     *  ====================
     *      a:0011
     *      a:0011
     *  0=a^a:0000
     *  ====================
     * @param nums
     * @return
     */
    private static int missingNumber(int[] nums) {
        int temp = nums.length;
        for (int i = 0; i < nums.length; i++) {
            temp = temp ^ i ^ nums[i];
        }
        return temp;
    }
}
