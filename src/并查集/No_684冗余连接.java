package 并查集;

/**
 * 并查集
 * https://leetcode-cn.com/problems/redundant-connection/solution/tong-su-jiang-jie-bing-cha-ji-bang-zhu-xiao-bai-ku/
 * 参考此题解
 */
public class No_684冗余连接 {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        // 初始化节点集合的代表节点为其自身
        // 未添加边时，各个节点集合独立
        int[] rpNode = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 索引i：当前节点
            // 值i：  当前节点所在集合的代表节点
            rpNode[i] = i;
        }

        // 边[a, b]意味着a节点所在集合可以和b节点所在集合合并
        for (int i = 0; i < n; i++) {
            int rp1 = findRepresentNode(edges[i][0], rpNode);
            int rp2 = findRepresentNode(edges[i][1], rpNode);
            // 若两个代表结点相等，说明出这俩都在树里面，出现了环
            if (rp1 == rp2) {
                return edges[i];
            } else {
                // 若不相等，则更新并入树的节点的代表节点
                rpNode[rp1] = rp2;
            }
        }
        return null;
    }

    private int findRepresentNode(int num, int[] rpNode) {
        // 对于一个集合的代表节点s，其rpNode[s] = s;
        while(rpNode[num] != num) {
            num = rpNode[num];
        }
        return num;
    }
}
