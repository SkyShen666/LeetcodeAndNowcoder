package A剑指Offer;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 比如n=3时，2*3的矩形块有3种覆盖方法：
 *  覆盖2*n的矩形，可先覆盖2*(1)，再覆盖2*(n-1)
 *               或先覆盖2*(2)，再覆盖2*(n-2)
 * R(1) = 1;
 * R(2) = 2;
 * R(n) = R(n-1) + R(n-2)
 */
public class 矩形覆盖 {
    public int RectCover(int target) {
        if (target <= 2) {
            return target;
        }
        int pre1 = 1, pre2 = 2;
        int rect = 0;
        for (int i = 3; i <= target; i++) {
            rect = pre1 + pre2;
            pre1 = pre2;
            pre2 = rect;
        }
        return rect;
    }
}
