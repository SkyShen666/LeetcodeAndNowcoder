package 排序;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No_347前K个高频元素 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] res = topKFrequent(nums, 2);
        int i = 0;
        for (int num : res) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static int[] topKFrequent(int[] nums, int k) {
        //使用字典统计每个数字出现的频率，元素为键，频率为值
        Map<Integer, Integer> frequencyForNum = new HashMap<>();
        for (int num : nums) {
            frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
        }

        // 桶排序
        //将频率作为下标，将对应的数字存入对应频率的桶中
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int num : frequencyForNum.keySet()) {
            int frequency = frequencyForNum.get(num);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(num);
        }

        //倒序遍历数组（桶）获取出从大到小的排序
        int[] topK = new int[k];
        int j = 0;
        for (int i = buckets.length - 1; i >= 0 && j < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    topK[j++] = num;
                }
            }
        }
        return topK;
    }
}
