package 二分查找;

/**
 * 二分查找
 * 参考题解：
 * https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/solution/c-er-fen-fa-744-xun-zhao-bi-mu-biao-zi-mu-da-de-zu/
 * target可能比letters中所有字符都小，也可能比letters中所有字符都大。
 * 因此第一个大于target值的下标的取值范围为[0, letters.size()]，因此left = 0, right = letters.size();
 */
public class No_744寻找比目标字母大的最小字母 {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int low = 0, high = n;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (letters[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return letters[low % n];
    }
}
