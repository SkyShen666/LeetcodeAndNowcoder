package 贪心思想;

// 参考题解：
// https://leetcode-cn.com/problems/non-decreasing-array/solution/xiang-xia-guai-dian-de-xun-zhao-yu-xiao-chu-by-joh/
public class No_665非递减数列 {
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }

        int n = nums.length;
        int cnt = 0;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                cnt++;
                if (cnt == 2) {
                    return false;
                }

                int tmp = nums[i];
                // 先向下拉低当前元素
                if (i == 0) {
                    nums[i] = nums[i + 1];
                } else {
                    nums[i] = nums[i - 1];
                }
                // 还是不管用，复原后再拉高后面的元素
                if (nums[i] > nums[i + 1]) {
                    nums[i] = tmp;
                    nums[i + 1] = nums[i];
                }
            }
        }

        return true;
    }
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

