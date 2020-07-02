package 每日一题;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方。
 * 保证base和exponent不同时为0
 */
public class 数值的整数次方 {
    public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1; //注意0的0次方数学上无意义，输出1是可以接受的
        }
        if (exponent == 1) {
            return base;
        }
        boolean isNegative = false;
        if (exponent < 0) {
            isNegative = true;
        }
        exponent = Math.abs(exponent);
        double power = Power(base * base, exponent / 2);
        if (exponent % 2 != 0) {
            power = power * base;
        }
        return isNegative == true ? 1 / power : power;
    }
}
