package 二分查找;

/**
 * 没做出来
 */
public class No_744 {
    public static void main(String[] args) {
        char[] letters = {'e', 'e', 'e', 'e', 'e', 'n', 'n'};
        char answer = nextGreatestLetter(letters, 'e'); //f
        System.out.println(answer);
    }

    private static char nextGreatestLetter(char[] letters, char target) {
        int l = 0, h = letters.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (letters[mid] <= target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return l < letters.length ? letters[l] : letters[0];
    }
}
