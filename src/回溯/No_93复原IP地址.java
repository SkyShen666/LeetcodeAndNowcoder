package 回溯;
import java.util.*;
public class No_93复原IP地址 {
    private static List<String> res;

    public static List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        if (len < 4 || len > 12) {
            return res;
        }

        Deque<String> path = new ArrayDeque<>(4);
        int splitTimes = 0;
        backtrack(s, len, splitTimes, 0, path, res);
        return res;
    }

    private static void backtrack(String s, int len, int splitTimes, int begin, Deque<String> path, List<String> res) {
        if (begin == len) {
            if (splitTimes == 4) {
                res.add(String.join(".", path));
            }
            return;
        }

        //  剪枝
        if (len - begin < (4 - splitTimes) || len - begin > 3 * (4 - splitTimes)) {
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (begin + i >= len) {
                break;
            }
            int ipSegment = isIpSegment(s, begin, begin + i);
            if (ipSegment != -1) {
                path.addLast(ipSegment + "");
                backtrack(s, len, splitTimes + 1, begin + i + 1, path, res);
                path.removeLast();
            }
        }
    }

    private static int isIpSegment(String s, int left, int right) {
        int len = right - left + 1;

        if(len > 1 && s.charAt(left) == '0') {
            return -1;
        }

        int res = 0;
        for (int i = left; i <= right; i++) {
            res = res * 10 + s.charAt(i) - '0';
        }

        if (res > 255) {
            return -1;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "25525511135";
        List<String> res =  restoreIpAddresses(s);
        System.out.println(res);
    }
}
