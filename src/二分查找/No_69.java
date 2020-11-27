package 二分查找;

/**
 * 参考题解：
 * https://leetcode-cn.com/problems/sqrtx/solution/er-fen-cha-zhao-niu-dun-fa-python-dai-ma-by-liweiw/
 */
public class No_69 {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        long left = 1, right = x / 2;
        while (left < right) {
            long mid = left + (right - left + 1) / 2;
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }

/*
    private static int mySqrt(int n) {
        int sqrt =(int) Math.sqrt(n);
        return sqrt;
    }
*/


}
