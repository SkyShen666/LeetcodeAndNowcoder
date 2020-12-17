package 哈希表;
import java.util.*;

// 单词按字典顺序排序
// https://leetcode-cn.com/problems/group-anagrams/solution/zhao-dao-wei-yi-de-jian-by-powcai/
public class No_49字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<List<String>>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] tmp = str.toCharArray();
            Arrays.sort(tmp);
            String key = String.valueOf(tmp);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
