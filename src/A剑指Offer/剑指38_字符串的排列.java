package A剑指Offer;

import java.util.*;

public class 剑指38_字符串的排列 {
    private List<String> list;
    private int n;
    private boolean[] visited;

    public String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }

        n = s.length();
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);   // 为了去重
        visited = new boolean[n];
        list = new LinkedList<>();
        StringBuilder path = new StringBuilder();
        dfs(charArr, 0, path);

        return list.toArray(new String[0]);
    }

    private void dfs(char[] charArr, int begin, StringBuilder path) {
        if (begin == n) {
            list.add(path.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) { // 防止重复
                if (i > 0 && charArr[i - 1] == charArr[i] && !visited[i - 1]) {
                    continue;
                }
                visited[i] = true;
                path.append(charArr[i]);
                dfs(charArr, begin + 1, path);
                path.deleteCharAt(path.length() - 1);
                visited[i] = false;
            }
        }
    }
}
