package 字符串;

import java.util.*;

/**
 *
 egg 和 add 同构，就意味着下边的映射成立
 e -> a
 g -> d
 也就是将 egg 的 e 换成 a, g 换成 d, 就变成了 add

 同时倒过来也成立
 a -> e
 d -> g
 也就是将 add 的 a 换成 e, d 换成 g, 就变成了 egg

 foo 和 bar 不同构，原因就是映射不唯一
 o -> a
 o -> r
 其中 o 映射到了两个字母

 参考题解：
 https://leetcode-cn.com/problems/isomorphic-strings/solution/javake-neng-bi-jiao-jian-dan-de-xie-fa-by-hao-fei-/

 要两个字符串的每个字符的映射都互相相等
 “ab”,
 "aa"
 需要 isSameStruct(s, t) && isSameStruct(t, s)
 */

public class No_205Isomorphic_Strings {
    private boolean isIsomorphic(String s, String t) {
        return isIsomorphicUtils(s, t) && isIsomorphicUtils(t, s);
    }

    private boolean isIsomorphicUtils(String s, String t) {
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                map.put(s.charAt(i), t.charAt(i));
            }
        }

        return true;
    }
}

    /**
     * 方法一：代码逻辑重复
     * @param s
     * @param t
     * @return
    private static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        HashMap<Character,Character> mapS = new HashMap<>();
        HashMap<Character,Character> mapT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            mapS.put(s.charAt(i),t.charAt(i));
            mapT.put(t.charAt(i),s.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) {
            if (mapS.get(s.charAt(i)) != t.charAt(i) || mapT.get(t.charAt(i)) != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
     */

