package 数学;

public class No_476数字的补数 {
//    public static void main(String[] args) {
//        int n = findComplement(2147483647); // 2147483647 = 2^31 - 1
//        System.out.println(n);
//    }

//    private static int findComplement(int num) {
//        int len = Integer.toString(num, 2).length(); // len = 31
//        System.out.println("len:" + len);
//
////        double mp = Math.pow(2, len);
////        System.out.println("mp: " + mp); // 2.147483648E9  2147483648 = 2^31
////        int temp = (int) Math.pow(2, len) - 1; // 2147483646
//
//        int mp = (int) Math.pow(2, len);
//        System.out.println("mp: " + mp); // 2.147483647E9  2147483647 = 2^31 - 1
          // 这里注意：2^31会超出int类型的最大表示范围
          // int类型最大表示范围为 -2147483648~2147483647 即 [-2^31, 2^31 - 1]
          // 因此必要要对(Math.pow(2, len) - 1)整体加括号，对它们进行整体强转，才不会出现精度错误！
//        int temp = (int) (Math.pow(2, len) - 1); // 2147483647
//
//        System.out.println("temp:" + temp);
//        return num ^ temp;
//    }

    public int findComplement(int num) {
        int tmp = 1;
        while (tmp < num) {
            tmp = tmp << 1;
            tmp += 1;
        }
        return tmp ^ num;
    }

}


