package 贪心思想;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No_763划分字母区间 {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        //遍历一次，更新出每个字母最后出现的位置
        for (int i = 0; i < S.length(); i++) {
            last[S.charAt(i) - 'a'] = i;
        }

        //anchor和j分别代表区间的首尾
        int anchor = 0, j = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            //遇到字符的最后一次出现的下标大于区间的尾坐标，即大于j，就让j=last[c]来扩展区间
            j = Math.max(j, last[S.charAt(i) - 'a']);
            //遍历到j==i时，即当前区间的尾坐标等于字符最后出现的坐标，把当前区间加入答案
            if (j == i) {
                res.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return res;
    }
}
