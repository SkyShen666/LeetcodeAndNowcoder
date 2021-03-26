package 每日一题;


public class 剑指58_2左旋转字符串 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(n, s.length()));
        sb.append(s.substring(0, n));

        return sb.toString();
    }
}

//    先整体反转 后局部分别反转
//    这种方法实际上不是原地调整，java的string不能改变。
//
//    public String LeftRotateString(String str,int n) {
//        if (str == null || str.length() == 0)
//            return "";
//        if (n >= str.length() || n < 0)
//            return str;
//        int len = str.length();
//        char[] chars = str.toCharArray();
//        //反转整个字符串
//        Reverse(chars, 0, len - 1);
//        //分别反转 两个子字符串
//        Reverse(chars, 0, len - 1 - n);
//        Reverse(chars, len - n, len - 1);
//        return new String(chars);
//    }
//
//    private void Reverse(char[] chars, int pBegin, int pEnd) {
//        while (pBegin < pEnd)
//            swap(chars, pBegin++, pEnd--);
//    }
//
//    private void swap(char[] chars, int i, int j) {
//        char temp = chars[i];
//        chars[i] = chars[j];
//        chars[j] = temp;
//    }