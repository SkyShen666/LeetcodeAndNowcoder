package 数学;

// 10进制转换成26进制
// 但需要注意的是：本题对应关系为[1,26]，而一个数对26取模范围在[0, 25], 所以在取模为0时，需要对n做 n - 1 处理！
// 正常的每一位的范围[0, 25]，对26取模 一定为0， 而本题每一位需要的范围为[1, 26]，
// 26 % 26 = 0， 而 26 / 26 = 1 注意这里 != 0, 这样就会出现错误，没有把整个数向右移动一位。
// 此时需要特殊处理：在取模为0时，需要对n做 n - 1 处理。
// 参考题解：
// https://leetcode-cn.com/problems/excel-sheet-column-title/solution/xiang-xi-tong-su-de-si-lu-fen-xi-by-windliang-2/
public class No_168Excel列表名称 {
    public String convertToTitle(int n) {
        StringBuilder str = new StringBuilder();

        while (n > 0) {
            int c = n % 26;
            if (c == 0) {
                c = 26;
                n = n - 1;
            }
            str.insert(0, (char)('A' + c - 1));
            n = n / 26;
        }

        return str.toString();
    }
}
