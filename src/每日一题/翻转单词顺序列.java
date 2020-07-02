package 每日一题;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。
 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class 翻转单词顺序列 {
    public static void main(String[] args) {
        String s = "I am a student.";
        System.out.println(ReverseSentence(s));
    }
    public static String ReverseSentence(String str) {
        if (str == null || str.length() == 0)
            return "";
        int len = str.length();
        int pBegin = 0, pEnd = len - 1;
        char[] chars = str.toCharArray();
        //反转整个字符串
        Reverse(chars, pBegin, pEnd);

        //反转句子中的每个单词
        pEnd = pBegin + 1;
        while (pEnd <= len) {
            if (pEnd == len || chars[pEnd] == ' ') {
                Reverse(chars, pBegin, pEnd - 1);
                pBegin = pEnd + 1;
                pEnd = pBegin + 1;
            }else
                pEnd++;
        }
        return new String(chars);
    }

    private static void Reverse(char[] c, int pBegin, int pEnd) {
        while (pBegin < pEnd) {
            swap(c, pBegin++, pEnd--);
        }
    }

    private static void swap(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
}
