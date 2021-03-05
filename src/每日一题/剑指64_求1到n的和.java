package 每日一题;

// 参考题解：
// https://leetcode-cn.com/problems/qiu-12n-lcof/solution/mian-shi-ti-64-qiu-1-2-nluo-ji-fu-duan-lu-qing-xi-/
public class 剑指64_求1到n的和 {
    private int sum = 0;

    public int sumNums(int n) {
        boolean b = n > 1 && sumNums(n - 1) > 0;
        sum += n;

        return sum;
    }
}
