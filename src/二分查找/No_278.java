package 二分查找;

public class No_278 {
    public static void main(String[] args) {
        int version = firstBadVersion(10);

    }

    private static int firstBadVersion(int n) {
        int l = 0, h = n;
/*        while (l < h) {
            int mid = l + (h - l) / 2;
            if (isBadVersion(mid)) { //相当于nums[mid] >= key
                h = mid;
            } else {
                l = mid + 1;
            }
        }*/
        return l;
    }

}
