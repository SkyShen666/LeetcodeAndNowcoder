package 哈希表;

import java.util.HashMap;

public class No_594Longest_Harmonious_Subsequence_Easy {
    public static void main(String[] args) {
        int[] nums = {1,3,2,2,5,2,3,7};
        int len = findLHS(nums);
        System.out.println(len);
    }

    private static int findLHS(int[] nums) {
        HashMap<Integer,Integer> countForNum = new HashMap<>();
        for (int num : nums) {
            countForNum.put(num, countForNum.getOrDefault(num, 0) + 1);
        }
        int longest = 0;
        for (int num : countForNum.keySet()) {
            if (countForNum.containsKey(num + 1)){
                longest = Math.max(longest, countForNum.get(num) + countForNum.get(num + 1));
            }
        }
        return longest;
    }

}
