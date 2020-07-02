package 动态规划;

public class No_303 {
    static int[] nums = {-2, 0, 3, -5, 2, -1};
    static int[] sum;

    public static void main(String[] args) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++){
            sum[i + 1] = sum[i] +nums[i];
        }
        int totalMoney = sumRange(0,5);
        System.out.println("totalMoney:" + totalMoney);
    }

    public static int sumRange(int i, int j) {
        int totalMoney = sum[j + 1] - sum[i];
        return totalMoney;
    }
}
