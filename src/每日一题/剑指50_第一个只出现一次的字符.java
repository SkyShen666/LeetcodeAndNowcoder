package 每日一题;

import java.util.*;

/**
 *  哈希表，HashMap（无序）
 *  参考题解：
 *  https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/solution/mian-shi-ti-50-di-yi-ge-zhi-chu-xian-yi-ci-de-zi-3/\
 *
 *  进阶：有序哈希表：LinkedHashMap
 *  第二次遍历 dic，次数会更少，dic长度 < 26
 */
public class 剑指50_第一个只出现一次的字符 {
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }

        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] charArr = s.toCharArray();
        for (char c : charArr) {
            dic.put(c, !dic.containsKey(c));
        }
        for (Map.Entry<Character, Boolean> d : dic.entrySet()) {
            if (d.getValue()) {
                return d.getKey();
            }
        }

        return ' ';
    }
}

//    哈希表：HashMap
//    public char firstUniqChar(String s) {
//        if (s == null || s.length() == 0) {
//            return ' ';
//        }
//
//        Map<Character, Boolean> dic = new HashMap<>();
//        char[] charArr = s.toCharArray();
//        for (char c : charArr) {
//            dic.put(c, !dic.containsKey(c));
//        }
//        for (char c : charArr) {
//            if (dic.get(c)) {
//                return c;
//            }
//        }
//
//        return ' ';
//    }
