import java.util.*;

public class practice327 {
    StringBuilder ans = new StringBuilder();

    public String maxCoins(int[] nums) {
        List<Integer> listNum = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            listNum.add(nums[i]);
        }
        helper(listNum, 0, ans);

        return ans.toString();
    }

    private void helper(List<Integer> list, int coins, StringBuilder ans) {
        if (list.size() == 0) {
//            System.out.println("===========");
            ans.append("a");
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            int temp = list.get(i);
            int delta = list.get(i) * (i - 1 >= 0 ? list.get(i - 1) : 1) * (i + 1 >= list.size() ? 1 : list.get(i + 1));
            list.remove(i);
            helper(list, coins + delta, ans);
            list.add(i, temp);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 5, 8};
        practice327 p = new practice327();
        System.out.println(p.maxCoins(nums));
    }
}
