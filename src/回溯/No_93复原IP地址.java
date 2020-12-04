package 回溯;
import java.util.*;

// 回溯法
// 参考题解：
// https://leetcode-cn.com/problems/restore-ip-addresses/solution/hui-su-suan-fa-hua-tu-fen-xi-jian-zhi-tiao-jian-by/

public class No_93复原IP地址 {
    private String s;
    private int len;
    private List<String> res;

    public List<String> restoreIpAddresses(String s) {
        res = new LinkedList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        len = s.length();
        if (len < 4 || len > 12) {
            return res;
        }

        // 初始化
        this.s = s;
        Deque<String> path = new LinkedList<>();

        dfs(0, 0, path);

        return res;
    }

    private void dfs(int splitCount, int begin, Deque<String> path) {
        if (begin == len) {
            if (splitCount == 4) {
                res.add(String.join(".", path));
            }
            return;
        }

        // 剪枝
        if ((len - begin) < (4 - splitCount) || (len - begin) > 3 * (4 - splitCount)) {
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (begin + i >= len) {
                break;
            }
            int ipSegment = isIpSegment(begin, begin + i);
            if (ipSegment != -1) {
                path.addLast(ipSegment + "");
                dfs(splitCount + 1, begin + i + 1, path);
                path.removeLast();
            }
        }
    }

    private int isIpSegment(int i, int j) {
        int len = j - i + 1;

        if (len > 1 && s.charAt(i) == '0') {
            return -1;
        }

        int res = 0;
        for (int k = i; k <= j; k++) {
            res = res * 10 + (s.charAt(k) - '0');
        }

        return res > 255 ? -1 : res;
    }
}
