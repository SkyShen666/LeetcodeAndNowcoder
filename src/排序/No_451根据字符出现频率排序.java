package 排序;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No_451根据字符出现频率排序 {
    public String frequencySort(String s) {
        Map<Character,Integer> frequencyForChar = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyForChar.put(c, frequencyForChar.getOrDefault(c, 0) + 1);
        }

        //桶排序
        List<Character>[] bucket = new ArrayList[s.length() + 1];
        for (char c : frequencyForChar.keySet()) {
            int frequency = frequencyForChar.get(c);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(c);
        }

        StringBuffer str = new StringBuffer();
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] == null) {
                continue;
            }
            for (char c : bucket[i]) {
                for (int j = 0; j < i; j++) {
                    str.append(c);
                }
            }
        }
        return str.toString();
    }
}
