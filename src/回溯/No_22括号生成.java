package 回溯;
import java.util.*;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
 *
 * 判断回溯很简单，拿到一个问题，你感觉如果不穷举一下就没法知道答案，那就可以开始回溯了。
 *
 * 一般回溯的问题有三种：
 *
 * Find a path to success 有没有解
 * Find all paths to success 求所有解
 * 求所有解的个数
 * 求所有解的具体信息
 * Find the best path to success 求最优解
 * 回溯法是一个剪枝了的二叉树。我们要得到的结果是可以 good leaf，如果不满足 good leaf 就继续向下搜索，搜索的时候需要满足一定的条件。
 *
 * 作者：fuxuemingzhu
 * 链接：https://leetcode-cn.com/problems/generate-parentheses/solution/ru-men-ji-bie-de-hui-su-fa-xue-hui-tao-lu-miao-don/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class No_22括号生成 {
    private List<String> list;
    private int n;

    public List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        if (n == 0) {
            return list;
        }

        this.n = n;
        StringBuilder str = new StringBuilder();

        dfs(0, 0, str);

        return list;
    }

    private void dfs(int left, int right, StringBuilder str) {
        if (left == n && right == n) {
            list.add(str.toString());
            return;
        }

        if (left > n || right > left) {
            return;
        }

        if (left <= n) {
            str.append("(");
            dfs(left + 1, right, str);
            str.deleteCharAt(str.length() - 1);
        }
        if (right <= n) {
            str.append(")");
            dfs(left, right + 1, str);
            str.deleteCharAt(str.length() - 1);
        }
    }
}

// 不使用StringBuilder，使用String
// 可以不显示地回溯
//
//    List<String> res = new ArrayList<>();
//
//    public List<String> generateParenthesis(int n) {
//        if (n == 0) {
//            return res;
//        }
//        dfs(n, n, "");
//        return res;
//    }
//
//    private void dfs(int left, int right, String path) {
//        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
//        // 在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
//        if (left == 0 && right == 0) {
//            res.add(path.toString());
//            return;
//        }
//
//
//        // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
//        if (left < 0 || right < left) {
//            return;
//        }
//
//        if (left > 0) {
//            dfs(left - 1, right, path + "(");
//        }
//
//        if (right > 0) {
//            dfs(left, right - 1, path + ")");
//        }
//    }