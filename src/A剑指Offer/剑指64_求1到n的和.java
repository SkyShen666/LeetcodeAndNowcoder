package A剑指Offer;

// 思路：
// 利用 逻辑运算符的短路效应
// 参考题解：
// https://leetcode-cn.com/problems/qiu-12n-lcof/solution/mian-shi-ti-64-qiu-1-2-nluo-ji-fu-duan-lu-qing-xi-/
public class 剑指64_求1到n的和 {
    public int sumNums(int n) {
        boolean b = n > 1 && (n += sumNums(n - 1)) > 0; //  当 n = 1 时 n > 1 不成立 ，此时 “短路” ，终止后续递归，然后执行下一行 return 1;

        return n;
    }
}
