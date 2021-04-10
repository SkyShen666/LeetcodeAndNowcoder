package 字符串;

public class No_14最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String res = strs[0]; // 以第一个字符串为标准
        for (int i = 1; i < strs.length; i++) {
            int end = 0;
            String str = strs[i];
            for (int j = 0; j < str.length(); j++) {
                if (j < res.length() && str.charAt(j) == res.charAt(j)) {
                    end++;
                } else {
                    break;
                }
            }
            res = res.substring(0, end);
            if (res.equals("")) {
                return res;
            }
        }

        return res;
    }
}
