package 排序;

/**
 * 荷兰国旗问题
 * 只需遍历一遍，把0移到最前面，把2移到最后面，1就不需要管了
 * [0, left) = 0
 * [left, right) = 1;
 * [right, len) = 2;
 * curr已经遍历过的元素
 */
public class No_75颜色分类 {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int p0 = 0, p2 = nums.length - 1;
        int curr = 0;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                swap(nums, curr, p0);
                curr++;
                p0++;
            } else if (nums[curr] == 1) {
                curr++;
            } else {
                swap(nums, curr, p2);
                p2--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
