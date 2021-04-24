package A剑指Offer;

/**
 * 同leetcode_8
 * 这题的做法大概是这样：
 * 1. 去掉前导空格
 * 2. 再是处理正负号
 * 3. 识别数字，注意越界情况。
 * 参考题解：
 * https://leetcode-cn.com/problems/string-to-integer-atoi/solution/java-zi-fu-chuan-zhuan-zheng-shu-hao-dong-by-sweet/
 */
public class 剑指67_把字符串转换成整数 {
    public int strToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int n = str.length();
        char[] charArr = str.toCharArray();
        int i = 0;
        // 1. 去掉前缀空格
        while (i < n && charArr[i] == ' ') {
            i++;
        }
        if (i == n) {
            // 整个字符串都是空格
            return 0;
        }
        // 2. 处理正负号
        boolean isNegative = false;
        if (charArr[i] == '-') {
            // 遇到负号
            isNegative = true;
            i++;
        } else if (charArr[i] == '+') {
            // 遇到正号
            i++;
        } else if (!Character.isDigit(charArr[i])) {
            // 遇到其它符号
            return 0;
        }
        // 3. 识别数字，注意越界情况
        int num = 0;
        while (i < n && Character.isDigit(charArr[i])) {
            int digit = charArr[i] - '0';
            if (num > (Integer.MAX_VALUE - digit) / 10) {
                // 本来应该是 ret * 10 + digit > Integer.MAX_VALUE
                // 但是 *10 和 + digit 都有可能越界，所以都移动到右边去就可以了。
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            num = num * 10 + digit;
            i++;
        }

        return isNegative ? -num : num;
    }
}
