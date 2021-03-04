package 每日一题;
import java.util.*;

/**
 * 题目规则：
 *  1、数字两边可以有空格，但是中间插空格不行；
 *  2、除了数字之外，合法字符还有'e'、'E'、'+'、'-'、'.'；
 *  3、'e'、'E'等价，用来划分底数与指数，只能出现一次，前面为科学计数法的底数，后面为指数；
 *  4、'+'、'-'只能作为正负号，但是不可以作为加减号，也就是只能出现在底数和指数的前面，不能出现在两个数字中间；
 *  5、'.'只能在底数上，不能在指数上，且只能出现一次，'.'两边任一边有数字均算一个完整的数字，但单独一个'.'不行。
 *
 * 解决方案：有限状态自动机
 * 参考题解：
 * https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/solution/mian-shi-ti-20-biao-shi-shu-zhi-de-zi-fu-chuan-y-2/
 *
 * 有限状态自动机 介绍
 * https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/solution/biao-shi-shu-zhi-de-zi-fu-chuan-by-leetcode-soluti/
 */
public class 剑指20_表示数值的字符串 {
    public boolean isNumber(String s) {
        Map[] states = {
                new HashMap<>(){{ put(' ', 0); put('s', 1); put('d', 2); put('.', 4); }},  // 0.
                new HashMap<>(){{ put('d', 2); put('.', 4); }},                            // 1.
                new HashMap<>(){{ put('d', 2); put('.', 3); put('e', 5); put(' ', 8); }},  // 2.
                new HashMap<>(){{ put('d', 3); put('e', 5); put(' ' , 8); }},              // 3.
                new HashMap<>(){{ put('d', 3); }},                                         // 4.
                new HashMap<>(){{ put('s', 6); put('d', 7); }},                            // 5.
                new HashMap<>(){{ put('d', 7); }},                                         // 6.
                new HashMap<>(){{ put('d', 7); put(' ', 8); }},                            // 7.
                new HashMap<>(){{ put(' ', 8); }}                                          // 8.
        };

        int p = 0;
        char t;
        for(char c : s.toCharArray()) {
            if(c >= '0' && c <= '9') t = 'd';
            else if(c == '+' || c == '-') t = 's';
            else if(c == 'e' || c == 'E') t = 'e';
            else if(c == '.' || c == ' ') t = c;
            else t = '?';

            if(!states[p].containsKey(t)) return false;
            p = (int)states[p].get(t);
        }

        return p == 2 || p == 3 || p == 7 || p == 8;
    }
}
