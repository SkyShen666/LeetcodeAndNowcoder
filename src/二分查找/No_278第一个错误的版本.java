package 二分查找;

// 二分查找
public class No_278第一个错误的版本 {
    public int firstBadVersion(int n) {
        int low = 1, high = n;

//        while (low < high) {
//            int mid = low + (high - low) / 2;
//            if (isBadVersion(mid)) { // 相当于：nums[mid] >= target
//                high = mid;
//            } else {
//                low = mid + 1;
//            }
//        }

        return low;
    }

}
