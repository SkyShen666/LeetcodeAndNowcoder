package A剑指Offer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Description:
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * <p>
 * Output:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class 字符流中第一个不重复的字符 {
    //放置字符和出现次数的映射关系
    private HashMap<Character,Integer> map = new HashMap<>();
    //放置出现的字符的顺序
    private ArrayList<Character> list = new ArrayList<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (map.containsKey(ch)) {
            map.put(ch, map.get(ch) + 1);
        } else {
            map.put(ch, 1);
        }
        list.add(ch);
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char ret = '#';
        for (char c : list) {
            if (map.get(c) == 1) {
                ret = c;
                break;
            }
        }
        return ret;
    }
}
