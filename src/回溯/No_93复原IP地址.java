package 回溯;
import java.util.*;

// 回溯法
// 参考题解：
// https://leetcode-cn.com/problems/restore-ip-addresses/solution/hui-su-suan-fa-hua-tu-fen-xi-jian-zhi-tiao-jian-by/

public class No_93复原IP地址 {
    private String s;
    private int n;
    private List<String> list;

    public List<String> restoreIpAddresses(String s) {
        list = new LinkedList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return list;
        }

        this.s = s;
        this.n = s.length();
        Deque<String> path = new LinkedList<>();
        dfs(0, 0, path);

        return list;
    }

    private void dfs(int splitCnt, int begin, Deque<String> path) {
        if (begin == n) {
            if (splitCnt == 4) {
                list.add(String.join(".", path));
            }
            return;
        }

        // 剪枝(不满足 最小、最大条件)
        if ((n - begin) < (4 - splitCnt) || (n - begin) > 3 * (4 - splitCnt)) {
            return;
        }
        // 寻找下一个ip地址块
        for (int i = 0; i < 3; i++) {
            if (begin + i >= n) {
                break;
            }
            int ipSegment = isIpSegment(begin, begin + i);
            if (ipSegment != -1) {
                path.addLast(ipSegment + "");
                dfs(splitCnt + 1, begin + i + 1, path);
                path.removeLast();
            }
        }
    }

    private int isIpSegment(int i, int j) {
        // ip地址块的长度大于1，且开头为'0'
        if (j - i + 1 > 1 && s.charAt(i) == '0') {
            return -1;
        }
        int ipSegment = 0;
        for (int k = i; k <= j; k++) {
            ipSegment = ipSegment * 10 + (s.charAt(k) - '0');
        }

        return ipSegment > 255 ? -1 : ipSegment;
    }
}
