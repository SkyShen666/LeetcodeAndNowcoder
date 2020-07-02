package 数学;

/**
 * Given an integer, return its base 7 string representation.
 */
public class No_504Base_7 {
    public static void main(String[] args) {
        String str = convertToBase(-100);
        System.out.println(str);
    }

    /**
     * 方法二：
     *      java中的static String toString(int i, int radix)可以把i转换为radix进制表示的字符串
     *radix：进制
     * @param num
     * @return
     */
    private static String convertToBase(int num) {
        return Integer.toString(num,7);
    }

/*
    private static String convertToBase(int num) {
        if(num == 0){
            return "0";
        }
        boolean isNegative = num < 0 ? true : false;
        if (isNegative){
            num = -num;
        }
        StringBuffer str = new StringBuffer();
        while (num > 0){
            str.append(num % 7);
            num = num / 7;
        }
        str = isNegative ? str.append("-") : str;
        return str.reverse().toString();
    }
*/


}
