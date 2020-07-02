package 数学;


/**
 * 负数二进制：按位取反 最末尾加1
 * 1 ：     00..00001
 * 按位取反：11..11110
 * -1:      11..11111
 * 16进制中负数的补码，-1的补码为15；-2：14；0：0；
 * Integer 共32位
 */
public class No_405Convert_a_Number_to_Hexadecimal {
    public static void main(String[] args) {
        String str = toHex(26);
        System.out.println(str);
    }


    private static String toHex(int num) {
        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        if (num == 0) {
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        while (num != 0) {
            sb.append(map[num & 15]);
            num = num >>> 4;
        }
        return sb.reverse().toString();
    }

}
