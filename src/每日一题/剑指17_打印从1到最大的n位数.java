package 每日一题;

/**
 * 此题应考虑大数
 * 参考答案：
 * https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/solution/mian-shi-ti-17-da-yin-cong-1-dao-zui-da-de-n-wei-2/
 * 考察频率很低
 */
public class 剑指17_打印从1到最大的n位数 {
    StringBuilder res;
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public String printNumbers(int n) {
        this.n = n;
        res = new StringBuilder();
        num = new char[n];
        start = n - 1;
        dfs(0);
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    void dfs(int x) {
        if (x == n) {
            String s = String.valueOf(num).substring(start);
            if (!s.equals("0")) res.append(s + ",");
            if (n - start == nine) start--;
            return;
        }
        for (char i : loop) {
            if (i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        nine--;
    }
}

//    不考虑大数的解法：
//
//    public int[] printNumbers(int n) {
//        int end = (int)Math.pow(10, n) - 1;
//        int[] ret = new int[end];
//
//        for (int i = 1; i <= end; i++) {
//            ret[i - 1] = i;
//        }
//
//        return ret;
//    }
