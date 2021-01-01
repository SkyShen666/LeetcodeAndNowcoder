package 每日一题;

/**
 * 二分法：
 */
public class 剑指_11旋转数组的最小数字 {
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("数组为空！");
        }

        int low = 0, high = numbers.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            // 警惕{1,3,3} 没旋转
            // 或 {3,3,1,3}
            // 防止没有旋转和最右侧元素与左侧元素重复
            if (numbers[mid] == numbers[high]) {
                high--;
            } else if (numbers[mid] > numbers[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return numbers[low];
    }
}
