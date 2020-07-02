package 哈希表;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class No_217Contains_Duplicate_Easy {
    public static void main(String[] args) {
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        boolean rs = containsDuplicate(nums);
        System.out.println(rs);
    }

    private static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }
}
