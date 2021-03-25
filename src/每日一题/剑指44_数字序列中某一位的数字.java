package 每日一题;

/**
 *
 * 通过区间，不断地减 n
 * 参考题解：
 * https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/solution/mian-shi-ti-44-shu-zi-xu-lie-zhong-mou-yi-wei-de-6/
 */
public class 剑指44_数字序列中某一位的数字 {
    public int findNthDigit(int n) {
        if (n == 0) {
            return 0;
        }

        int digit = 1;  // 每个数的位数，如：10:2位
        long start = 1; // 开始，如 1~9:1, 10~99:10 (有越界的情况，要用long)
        long count = 9; // 每个区间多少个数字(位数)，如：10~99:180位
        // 1. 确定n所在数字的位数(计算出start和**digit**)
        while (n > count) {
            n -= count;
            start *= 10;
            digit++;
            count = digit * start * 9;
        }
        // 2. 确定n所在的数字(有越界的情况，要用long)，找到起始为start的第(n - 1) / digit个数
        long num = start + (n - 1) / digit;

        // 3. 确认n在num的哪一位，(在数字num的第(n - 1) % digit 位)
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
