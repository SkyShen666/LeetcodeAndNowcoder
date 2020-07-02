package 二分查找;

public class No_69 {
    public static void main(String[] args) {
        int n = mySqrt(8);
        System.out.println(n);
    }

    private static int mySqrt(int x) {
        if(x <= 1){
            return x;
        }
        int l = 1, h = x;
        while (l <= h){
            int mid = l + (h - l) / 2;
            int sqrt = x / mid;
            if(sqrt == mid){
                return sqrt;
            }else if(sqrt < mid){
                h = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return h;
    }

/*
    private static int mySqrt(int n) {
        int sqrt =(int) Math.sqrt(n);
        return sqrt;
    }
*/


}
