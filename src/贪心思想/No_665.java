package 贪心思想;

public class No_665 {
    public static void main(String[] args) {
        int[] nums = {2,3,3,2,4};
        System.out.println(checkPossibility(nums));
    }

    private static boolean checkPossibility(int[] nums) {
        if (nums.length == 0 || nums == null){
            return false;
        }
        int count = 0;
        for (int i = 1; i < nums.length && count < 2; i++){
            if(nums[i - 1] <= nums[i]){
                continue;
            }
            count++;
            //nums[i-1] > nums[i]
            if(i - 2 >= 0 && nums[i - 2] > nums[i]){
                nums[i] = nums[i - 1];
            }else {
                nums[i - 1] = nums[i];
            }
        }
        return count <= 1;
    }



/*
        private static boolean checkPossibility(int[] nums) {
        if (nums.length == 0 || nums == null){
            return false;
        }
        int flag = 1;
        for (int i = 0; i < nums.length - 1; i++){
            if(nums[i] <= nums[i+1]){
                continue;
            }else if(flag == 1){
                if(i == 0){
                    nums[i] = nums[i+1];
                    flag = 0;
                }else if (nums[i - 1] <= nums[i + 1]){
                    nums[i] = nums[i+1];
                    flag = 0;
                }else if (nums[i - 1] > nums[i + 1]){
                    nums[i+1] = nums[i];
                    flag = 0;
                } else {
                    return false;
                }
            }else {
                return false;
            }
        }
        return true;
    }
*/

}
