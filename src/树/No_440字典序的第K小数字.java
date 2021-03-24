package 树;

public class No_440字典序的第K小数字 {
    public int findKthNumber(int n, int k) {
        int cur = 1; // 跨过0从1开始
        k = k - 1;  // 扣除第一个0节点
        while (k > 0) {
            int cnt = countNode(n, cur, cur + 1);
            if (cnt <= k) { // 第k个数不在以cur为根结点的树上
                cur++;  // cur在字典树中，在同一层向右移动
                k -= cnt;
            } else {    // 在cur为根结点的子树中
                cur *= 10;  // cur 移动到下一层
                k--;    // 刨除根结点
            }
        }

        return cur;
    }

    private int countNode(int n, long pre, long next) {
        int cnt = 0;
        while (pre <= n) {
            cnt += Math.min(n + 1, next) - pre; // 比如n是195的情况195到100有96个数
            pre *= 10;
            next *= 10;
        }

        return cnt;
    }
}
