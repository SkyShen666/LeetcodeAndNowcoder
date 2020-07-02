package 每日一题;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class 替换空格 {
    public String replaceSpace(StringBuffer str) {
        int p1 = str.length() - 1;
        for (int i = 0; i <= p1; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }

        int p2 = str.length() - 1;
        while (p1 >= 0 && p1 <= p2) {
            if (str.charAt(p1) == ' ') {
                p1--;
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            } else {
                char c = str.charAt(p1--);
                str.setCharAt(p2--, c);
            }
        }
        return str.toString();
    }
}
