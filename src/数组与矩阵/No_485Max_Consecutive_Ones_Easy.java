package 数组与矩阵;

public class No_485Max_Consecutive_Ones_Easy {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        int n = findMaxConsecutiveOnes(nums);
        System.out.println(n);
    }

    private static int findMaxConsecutiveOnes(int[] nums) {
        int maxLen = 0, cur = 0;
        for (int num : nums) {
            cur = num == 1 ? cur + 1 : 0;
            maxLen = Math.max(cur,maxLen);
        }
        return maxLen;
    }


/*    private static int findMaxConsecutiveOnes(int[] nums) {
        int maxLen = 0;
        int temp = 0;
        for (int num : nums) {
            if (num != 1){
                temp = 0;
            } else if (num == 1) {
                temp++;
                if (temp > maxLen) {
                    maxLen = temp;
                }
            }
        }
        return maxLen;
    }*/

}
