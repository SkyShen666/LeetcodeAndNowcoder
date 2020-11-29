package 排序;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No_451根据字符出现频率排序 {
    public String frequencySort(String s) {
        int len = s.length();
        if (len == 0) {
            return "";
        }

        Map<Character, Integer> frequencyForChar = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyForChar.put(c, frequencyForChar.getOrDefault(c, 0) + 1);
        }

        // 桶排序
        List<Character>[] buckets = new ArrayList[len + 1];
        for (char c : frequencyForChar.keySet()) {
            int frequency = frequencyForChar.get(c);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(c);
        }

        StringBuilder str = new StringBuilder();
        for (int i = buckets.length - 1; i >= 1; i--) {
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    for (int j = 0; j < i; j++) {
                        str.append(c);
                    }
                }
            }
        }

        return str.toString();
    }
}
