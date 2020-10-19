package 字符串;

/**
 * https://leetcode-cn.com/problems/backspace-string-compare/solution/bi-jiao-han-tui-ge-de-zi-fu-chuan-by-leetcode-solu/
 * 官方题解,双指针法
 */
public class No_844比较含退格的字符串 {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;
        int skipS = 0;
        int skipT = 0;
        // 逆序遍历
        while (i >=0 || j >= 0) {
            // 检查目前的退格数量,并退格
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    // 记录退格数量
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    // 退格
                    skipS--;
                    i--;
                } else {
                    // 没有退格了,并且不需要继续退格
                    break;
                }
            }

            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }

            // 比较当前的字符
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else { // 第一个可能是退格符"#",退格符不计入比较范围
                // 有一个字符串已经比较完,另一个还有字符没有比较完
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            // 继续比较下一个字符
            i--;
            j--;
        }
        return true;
    }
}
