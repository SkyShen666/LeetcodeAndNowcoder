package 贪心思想;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No_763划分字母区间 {
    private List<Integer> res;

    public List<Integer> partitionLabels(String S) {
        res = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return res;
        }

        int len = S.length();
        int[] last = new int[26];
        // 遍历一次，更新出每个字母最后出现的位置
        for (int i = 0; i < len; i++) {
            last[S.charAt(i) - 'a'] = i;
        }

        // begin和end分别代表区间的首尾
        int begin = 0, end = 0;
        for (int i = 0; i < len; i++) {
            // 遇到字符的最后一次出现的下标大于区间的尾坐标，即大于j，就让j = last[c]来扩展区间
            end = Math.max(end, last[S.charAt(i) - 'a']);
            // 遍历到j == i时，即当前区间的尾坐标等于字符最后出现的坐标，把当前区间加入答案
            if (end == i) {
                res.add(i - begin + 1);
                begin = i + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";
        No_763划分字母区间 test = new No_763划分字母区间();
        List<Integer> list = test.partitionLabels(S);
        for (int num : list) {
            System.out.print(num + ",");
        }
    }
}
