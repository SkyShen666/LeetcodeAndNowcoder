package 数学;

public class No_167两数之和2输入有序数组 {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum < target){
                i++;
            } else {
                j--;
            }
        }
        return null;
    }
}
