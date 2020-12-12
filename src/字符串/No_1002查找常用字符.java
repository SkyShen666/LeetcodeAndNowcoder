package 字符串;

import java.util.*;

public class No_1002查找常用字符 {
    public List<String> commonChars(String[] A) {
        List<String> list = new ArrayList<>();
        if (A == null || A.length == 0) {
            return list;
        }

        Map<Character, Integer> map = new HashMap<>();

        // 用第一个字符串给hash初始化
        for (char c : A[0].toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 统计除第一个字符串外字符的出现频率
        for (int i = 1; i < A.length; i++) {
            Map<Character, Integer> map2 = new HashMap<>();
            for (Character c : A[i].toCharArray()) {
                if (map.containsKey(c)) {
                    // 更新hash，保证hash里 统计共同出现的字符，出现的次数最小
                    int val = Math.min(map.get(c), map2.getOrDefault(c, 0) + 1);
                    map2.put(c, val);
                }
            }
            // 更新哈希表
            map = map2;
        }

        for (char c : map.keySet()) {
            int n = map.get(c);
            for (int i = 0; i < n; i++) {
                list.add(String.valueOf(c));
            }
        }

        return list;
    }
}
