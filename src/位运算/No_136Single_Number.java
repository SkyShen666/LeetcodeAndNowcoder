package 位运算;

public class No_136Single_Number {
    public static void main(String[] args) {
        int[] nums = {2,2,1};//1 ;  [4,1,2,1,2] 4
        int n = singleNumber(nums);
        System.out.println(n);
    }

    private static int singleNumber(int[] nums) {
        int flag = 0;
        for(int num : nums){
            flag = flag ^ num; //相等就归零了，不相等就等num
        }
        return flag;
    }
}
