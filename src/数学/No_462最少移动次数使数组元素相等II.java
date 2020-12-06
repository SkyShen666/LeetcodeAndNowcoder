package 数学;
import java.util.Arrays;

// 相遇问题，移动距离最小的方式是所有元素都移动到中位数
// 设m为中位数，若a <= m <= b, 则若想使a，b都化为m，需要的步数为(m-a) + (b - m) 即 b - a
public class No_462最少移动次数使数组元素相等II {
    public int minMoves2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int n = nums.length;
        int low = 0, high = n - 1;
        int cnt = 0;

        while (low < high) {
            cnt += nums[high] - nums[low];
            low++;
            high--;
        }

        return cnt;
    }
}
