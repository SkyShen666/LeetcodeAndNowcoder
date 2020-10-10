package 排序;

public class No_75颜色分类 {
    //荷兰国旗问题
    //只需遍历一遍，把0移到最前面，把2移到最后面，1就不需要管了
    public void sortColors(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }
        // [0, left) = 0
        // [left, right) = 1;
        // [right, len - 1] = 2;
        // curr已经遍历过的元素
        int left = 0;
        int right = len;
        int curr = 0;
        while (curr < right) {
            if (nums[curr] == 0) {
                swap(nums, curr, left);
                left++;
                curr++;
            } else if (nums[curr] == 1) {
                curr++;
            } else {
                right--;
                swap(nums, curr, right);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
