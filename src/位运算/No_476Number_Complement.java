package 位运算;

public class No_476Number_Complement {
    public static void main(String[] args) {
        int n = findComplement(5);
        System.out.println(n);
    }

    /**
     * 101
     * @param num
     * @return
     */
    private static int findComplement(int num) {
        int len = Integer.toString(num,2).length();
        int temp = (int) (Math.pow(2,len) - 1);
        return num ^ temp;
    }
}
