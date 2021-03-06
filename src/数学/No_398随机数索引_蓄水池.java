package 数学;

import java.util.*;

// 蓄水池问题
public class No_398随机数索引_蓄水池 {
    private Map<Integer, ArrayList<Integer>> map;

    public No_398随机数索引_蓄水池(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> datastream = map.get(target);
        int index = new Random().nextInt(datastream.size());
        return datastream.get(index);
    }
}
