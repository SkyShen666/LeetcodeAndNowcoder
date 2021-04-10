
/**
 * 把一个字符串的大写字母放到字符串的后面，各个字符的相对位置不变，
 * 且不能申请额外的空间。
 *
 * 输入描述:
 * 输入数据有多组，每组包含一个字符串s，且保证:1 <= s.length <= 1000.
 *
 * 输出描述:
 * 对于每组数据，输出移位后的字符串。
 *
 * 输入例子:
 * AkleBiCeilD
 * 输出例子:
 * kleieilABCD
 */
public class Tencent_305 {
    public String sortString(String str) {
        if (str == null) {
            return null;
        }
        char[] charArr = str.toCharArray();
        int n = str.length();
        for (int i = n - 1; i > 0; i--) {
            // 若为小写字母，记录小写字母的窗口（此窗口中全部为小写字母）,i为窗口右边指针
            if (charArr[i] >= 'a' && charArr[i] <= 'z') {
                int j = i; // 窗口的左边的指针
                while (j >= 1 && charArr[j] >= 'a' && charArr[j] <= 'z') {
                    j--;
                }
                if (j == 0 && charArr[j] >= 'a' && charArr[j] <= 'z') { // 注意边界条件
                    break;
                }
                if (charArr[j] >= 'A' && charArr[j] <= 'Z') {
                    char tmp = charArr[j];
                    for (int k = j; k < i; k++) {   // 将此区间整体往左移
                        charArr[k] = charArr[k + 1];
                    }
                    charArr[i] = tmp;
                }
            }
            // 若为大写字母，继续循环
        }

        return new String(charArr);
    }

    public static void main(String[] args) {
        Tencent_305 obj = new Tencent_305();
        String s = obj.sortString("AkleBiCeilD");
        System.out.println(s);
    }
}
