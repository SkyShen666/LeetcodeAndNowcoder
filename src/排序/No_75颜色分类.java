package 排序;

public class No_75颜色分类 {
    //荷兰国旗问题
    //只需遍历一遍，把0移到最前面，把2移到最后面，1就不需要管了
    public void sortColors(int[] nums) {
        int p = 0, q = nums.length - 1, curr = 0;
        while (curr <= q) {
            if (nums[curr] == 0) {
                swap(nums,curr,p);
                p++;
                curr++;  //注意区别
            } else if (nums[curr] == 2) {
                swap(nums,curr,q);
                q--;
            } else {
                curr++;
            }

        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
