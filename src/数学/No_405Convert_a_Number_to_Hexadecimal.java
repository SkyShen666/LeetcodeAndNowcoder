package 数学;


/**
 * 负数二进制：按位取反 最末尾加1
 * 1 ：     00...00001
 * 按位取反：11...11110
 * -1:      11...11111
 * 16进制中负数的补码，-1的补码为15；-2：14；0：0；
 * Integer 共32位
 */
public class No_405Convert_a_Number_to_Hexadecimal {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder str = new StringBuilder();

        while (num != 0) {
            str.append(map[num & 15]);
            num = num >>> 4;
        }

        return str.reverse().toString();
    }
}
