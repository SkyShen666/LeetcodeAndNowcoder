package 数学;

class No_504七进制数 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }

        boolean isNegative = num < 0 ? true : false;
        if (isNegative) {
            num = -num;
        }
        StringBuilder str = new StringBuilder();

        while (num > 0) {
            str.append(num % 7);
            num = num / 7;
        }
        str = isNegative ? str.append("-") : str;

        return str.reverse().toString();
    }
}

//    /**
//     * 方法二：
//     * java中的static String toString(int i, int radix)可以把i转换为radix进制表示的字符串
//     * radix：进制
//     *
//     * @param num
//     * @return
//     */
//    private static String convertToBase(int num) {
//        return Integer.toString(num, 7);
//    }

