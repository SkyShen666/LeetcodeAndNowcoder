package 每日一题;

/**
 * 同leetcode_8
 * 这题的做法大概是这样：
 *      1. 去掉前导空格
 *      2. 再是处理正负号
 *      3. 识别数字，注意越界情况。
 * 参考题解：
 * https://leetcode-cn.com/problems/string-to-integer-atoi/solution/java-zi-fu-chuan-zhuan-zheng-shu-hao-dong-by-sweet/
 */
public class 剑指67_把字符串转换成整数 {
    public int strToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int n = str.length();
        char[] chars = str.toCharArray();
        int i = 0;

        // 1. 去掉前导空格
        while (i < n && chars[i] == ' ') {
            i++;
        }

        if (i == n) {
            // 去掉前导空格后到了末尾
            return 0;
        }

        // 2. 再是处理正负号
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
                // 3. 识别数字，注意越界情况。
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
