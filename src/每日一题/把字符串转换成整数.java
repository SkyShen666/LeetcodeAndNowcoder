package 每日一题;

/**
 * 同leetcode_8
 * 参考题解：
 * https://leetcode-cn.com/problems/string-to-integer-atoi/solution/java-zi-fu-chuan-zhuan-zheng-shu-hao-dong-by-sweet/
 * Description：
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * Input:
 * 输入一个字符串,包括数字字母符号,可以为空
 * Output:
 * 如果是合法的数值表达则返回该数字，否则返回0
 */
public class 把字符串转换成整数 {
    public int strToInt(String str) {
        if (str == null || str.length() == 0)
            return 0;

        int n = str.length();
        char[] chars = str.toCharArray();
        int i = 0;

        while (i < n && chars[i] == ' ') {
            // 去掉前导空格
            i++;
        }

        if (i == n) {
            // 去掉前导空格后到了末尾
            return 0;
        }

        boolean isNegative = false;

        if (chars[i] == '-') {
            // 遇到负号
            isNegative = true;
            i++;
        } else if (chars[i] == '+') {
            // 遇到正号
            i++;
        } else if (!Character.isDigit(chars[i])) {
            // 遇到其它符号
            return 0;
        }

        int ret = 0;
        while (i < n && Character.isDigit(chars[i])) {
            int digit = chars[i] - '0';
            if (ret > (Integer.MAX_VALUE - digit) / 10) {
                // 本来应该是 ret * 10 + digit > Integer.MAX_VALUE
                // 但是 *10 和 + digit 都有可能越界，所以都移动到右边去就可以了。
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ret = ret * 10 + digit;
            i++;
        }

        return isNegative ? -ret : ret;
    }
}
