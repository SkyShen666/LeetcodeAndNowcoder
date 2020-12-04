package 数学;
import java.util.*;

public class No_9回文数 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        List<Integer> list = new ArrayList<>();
        while (x > 0) {
            list.add(x % 10);
            x = x / 10;
        }

        int i = 0, j = list.size() - 1;
        while (i < j) {
            if (list.get(i) != list.get(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
