package 二分查找;

public class binarySearch {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int n = binarySearch(nums,4);
        System.out.println(n);
    }

    public static int binarySearch(int[] nums,int key){
        int l = 0, h = nums.length - 1;
        while (l <= h){
            int mid = l + (h - l) / 2;
            if(nums[mid] == key){
                return mid;
            }else if (nums[mid] > key){
                h = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
