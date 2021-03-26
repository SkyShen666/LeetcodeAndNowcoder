package 每日一题;

// 二分查找: 排序数组中的搜索问题，首先想到 二分法 解决
// 左子数组： nums[i] = i;
// 右子数组： nums[i] != i;
// 缺失的数字等于：“右子数组的首位元素” 对应的索引
// 即此题可转化为： 使用二分法查找“右子数组的首位元素”
// 注意！！！
// [0,1,2,3,4,5,6] 应输出：7
// 数组的长度为 n - 1 , 此时的数组长度length = 7, 则 n - 1 = 7 ==> n = 8
// 所以查找的范围为 [0, 7]
// 参考题解：(注意二分查找的两种开闭情况！！！)
// https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/solution/xiang-jie-er-fen-cha-zhao-de-liang-chong-kai-bi-qi/
public class 剑指53_2缺失的数字 {
    public int missingNumber(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}

//    注意二分查找的两种开闭情况！！！
//    public int missingNumber(int[] nums) {
//        int low = 0, high = nums.length;
//        while (low < high) {
//            int mid = low + (high - low) / 2;
//            if (nums[mid] == mid) {
//                low = mid + 1;
//            } else if (nums[mid] > mid) {
//                high = mid;
//            }
//        }
//
//        return low;
//    }