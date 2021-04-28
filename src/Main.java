import java.util.Scanner;
public class Main {
//    private int maxNumberOne(int[] nums) {
//        int n = nums.length;
//        int max = 0;
//        int l = 0, r = 0, k = 0;
//        boolean flag = false;
//        for (int i = 0; i < n; i++) {
//            flag = false;
//            l = i;
//            while (i < n && nums[i] == 1) i++;
//            while (i < n && nums[i] == 0) {
//                flag = true;
//                i++;
//            }
//            k = i;
//            while (i < n && nums[i] == 1) i++;
//            r = i - 1;
//            max = Math.max(max, r - l + 1);
//            if (i > 0 && i != n && flag && nums[i - 1] == 1) { // 有0，且结尾为1
//                i = k - 1;
//            }
//        }
//
//        return max;
//    }

//    public static void main(String[] args) {
//        Main obj = new Main();
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) { // 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            int t = in.nextInt();
//            int n, m, k;
//            for (int i = 0; i < 3; i++) {
//                n = in.nextInt();
//                m = in.nextInt();
//                k = in.nextInt();
//            }
//            int[] nums = new int[n];
//            for (int i = 0; i < n; i++) {
//                nums[i] = in.nextInt();
//            }
//            System.out.println(11);
//        }
//    }
}

//    private Deque<Long> queue;
//
//    private long experimentRecord(long n) {
//        queue = new LinkedList<>(); // 记录加进去的天数
//        int bit = 1;
//        long cnt = 0; // 记录天数，从倒数第一天算起
//        while (n > 0) {
//            if ((n & bit) != 0) {
//                queue.addFirst(cnt);
//            }
//            n = n >> 1;
//            cnt++;
//        }
//
//        return cnt;
//    }
//
//    public static void main(String[] args) {
//        Main obj = new Main();
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            int t = in.nextInt();
//            for (int i = 0; i < t; i++) {
//                long n = in.nextInt();
//                long cnt = obj.experimentRecord(n); // 实验过程共cnt天
//                System.out.println(cnt);
//                long size = obj.queue.size();
////                long[] nums = new long[size];
////                for (long j = 0; j < size; j++) {
////                    nums[j] = cnt - obj.queue.pollFirst();
////                }
//                for (long j = 0; j < size; j++) {
//                    System.out.print(cnt - obj.queue.pollFirst() + " ");
//                }
//                System.out.println();
//            }
//        }
//    }