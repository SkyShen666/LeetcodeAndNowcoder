package 每日一题;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * 1、通过位异或运算(^)看作是没有进位的相加
 * 2、计算进位的位置，通过位与运算（&）和左移一位(<<)
 * 3、直到不产生进位为止
 */
public class 不用加减乘除做加法 {
    public int Add(int num1,int num2) {
        int sum, carry;
        do {
            sum = num1 ^ num2; //没有进位的相加
            carry = (num1 & num2) << 1; //计算进位
            num1 = sum;
            num2 = carry;
        } while (num2 != 0);
        return sum;
    }
}
