package 每日一题;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。
 * 其中负数用补码表示。
 * n & (n - 1) ：去除n的位级表示中最低的一位
 * n :       10110100
 * n-1 :     10110011
 * n&(n-1) : 10110000
 */
public class 二进制中1的个数 {
    public int NumberOf1(int n) {
        int cnt = 0;
        int temp = 1;
        while (temp != 0) {
            if ((temp & n) != 0) {
                cnt++;
            }
            temp <<= 1;
        }
        return cnt;
    }
}
/**
 public int NumberOf1(int n) {
 int cnt = 0;
 while (n != 0) {
 cnt++;
 n &= (n - 1);
 }
 return cnt;
 }
 */