package 排序;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No_347前K个高频元素 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        List<Integer> list = topKFrequent(nums, 2);
        int i = 0;
        while (list.iterator().hasNext()) {
            Integer next = list.iterator().next();
            System.out.print(next + " ");
        }
        System.out.println();
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        //使用字典统计每个数字出现的频率，元素为键，频率为值
        Map<Integer, Integer> frequencyForNum = new HashMap<>();
        for (int num : nums) {
            if (frequencyForNum.containsKey(num)) {
                frequencyForNum.put(num, frequencyForNum.get(num) + 1);
            } else {
                frequencyForNum.put(num, 1);
            }
        }

        //桶排序
        //将频率作为下标，将对应的数字存入对应频率的桶中
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (Integer key : frequencyForNum.keySet()) {
            int frequency = frequencyForNum.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }

        //倒序遍历数组（桶）获取出从大到小的排序
        List<Integer> topK = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
            if (buckets[i] == null) {
                continue;
            }
            topK.addAll(buckets[i]);
        }
        return topK;
    }
}
