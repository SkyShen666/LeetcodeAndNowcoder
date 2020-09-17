package 并查集;

/**
 * 参考题解：
 * https://leetcode-cn.com/problems/redundant-connection-ii/solution/bing-cha-ji-java-by-liweiwei1419/
 */
public class No_685冗余连接2 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] inDegree = new int[n + 1];

        // 处理入度数组
        for (int[] edge : edges) {
            inDegree[edge[1]] ++;
        }

        // 先尝试 若删除构成入度为2的结点的边，看是否形还成环（用并查集操作）
        for (int i = n - 1; i >= 0; i--) {
            if (inDegree[edges[i][1]] == 2) {
                // 剩下的若不构成环，则应该去掉这条边
                if (!judgeCircle(edges, n, i)) {
                    return edges[i];
                }
            }
        }

        // 若无入度为2的结点，尝试删除入度为1的有向边，看剩下的是否成环
        for (int i = n - 1; i >= 0; i--) {
            // 不能删除入度为0的有向边
            if(inDegree[edges[i][1]] == 1) {
                // 剩下的不成环，应该删除此边
                if(!judgeCircle(edges, n, i)) {
                    return edges[i];
                }
            }
        }
        return null;
    }

    private boolean judgeCircle(int[][] edges, int n, int removeEdgeIndex) {
        UnionFind uf = new UnionFind(n + 1);
        for (int i = 0; i < n; i++) {
            // 假设删掉了那条边
            if (i == removeEdgeIndex)
                continue;
            // 合并失败，表明构成了环
            if (!uf.union(edges[i][0], edges[i][1]))
                return true;
        }
        return false;
    }

    private class UnionFind{
        int[] rpNode;

        public UnionFind(int n) {
            rpNode = new int[n];
            // 初始化代表结点
            for (int i = 1; i <= n; i++) {
                rpNode[i] = i;
            }
        }

        public int findRepresentNode(int num) {
            while(num != rpNode[num]) {
                num = rpNode[num];
            }
            return num;
        }

        public boolean union(int x, int y) {
            int rp1 = findRepresentNode(x);
            int rp2 = findRepresentNode(y);
            // 代表结点相同，说明都已经在树中,无需合并
            if (rp1 == rp2) {
                return false;
            }
            // 代表结点不同，x合并到树中
            rpNode[rp1] = rp2;
            return true;
        }
    }
}
