package 哈希表;
import java.util.*;
public class No_771宝石与石头 {
    public int numJewelsInStones(String J, String S) {
        int sum = 0;
        if (S.length() == 0 || S == null) {
            return sum;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))) {
                sum++;
            }
        }
        return sum;
    }
}
