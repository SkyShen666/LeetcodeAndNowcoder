package 每日一题;

/**
 * Description：
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * Input:
 * 输入一个字符串,包括数字字母符号,可以为空
 * Output:
 * 如果是合法的数值表达则返回该数字，否则返回0
 */
public class 把字符串转换成整数 {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0)
            return 0;
        boolean isNegative = str.charAt(0) == '-';
        long ret = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '-' || c == '+'))
                continue;
            if (c < '0' || c > '9')
                return 0;
            ret = ret * 10 + (c - '0');
        }
        if (isNegative) {
            if ((0 - ret) < Integer.MIN_VALUE)
                return 0;
            else
                return (int) (0 - ret);
        } else {
            if (ret > Integer.MAX_VALUE)
                return 0;
            else
                return (int)ret;
        }
    }
}
