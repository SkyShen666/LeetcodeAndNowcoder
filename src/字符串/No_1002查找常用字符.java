package 字符串;
import java.util.*;
public class No_1002查找常用字符 {
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        if (A == null || A.length == 0) {
            return res;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : A[0].toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 1; i < A.length; i++) {
            Map<Character, Integer> map2 = new HashMap<>();
            for (Character c : A[i].toCharArray()) {
                if(map.containsKey(c)) {
                    map2.put(c, Math.min(map2.getOrDefault(c, 0) + 1, map.get(c)));
                }
            }
            map = map2;
        }
        for (Character c : map.keySet()) {
            int num = map.get(c);
            for (int i = 0; i < num; i++) {
                res.add(String.valueOf(c));
            }
        }
        return res;
    }
}
