package 并查集;

/**
 * 并查集与拓扑排序
 * 参考题解：
 * https://leetcode-cn.com/problems/redundant-connection-ii/solution/bing-cha-ji-java-by-liweiwei1419/
 *
 * 关于拓扑排序
 * https://www.jianshu.com/p/b59db381561a
 * 此题没有使用拓扑排序，而是使用了拓扑排序中引出的 “入度” 的概念
 * 此题目的示例就分别展示了有入度为2额得节点和无入度为2的节点的图，分别成环的例子。
 *
 * 关于有根树：
 * 有根树指满足以下条件的 有向图。该树 只有 一个根结点，所有其他结点都是该根结点的后继 。每一个结点 只有 一个父结点，除了根结点没有父结点。
 * 特点：没有环（不论是对于有向图还是无向图）
 */
public class No_685冗余连接2 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] inDegree = new int[n + 1];

        // 统计每个节点的入度
        for (int[] edge : edges) {
            inDegree[edge[1]] ++;
        }

        // 尝试删除构成入度为2的节点的边
        // 若删除后不成环（用并查集操作），则说明就是这个边
        for (int i = n - 1; i >= 0; i--) {
            if (inDegree[edges[i][1]] == 2) {
                // 剩下的若不构成环，则应该去掉这条边
                if (!judgeCircle(edges, i)) {
                    return edges[i];
                }
            }
        }

        // 若无入度为2的结点
        // 尝试删除入度为1的有向边，看剩下的是否成环
        for (int i = n - 1; i >= 0; i--) {
            // 不能删除入度为0的有向边
            if(inDegree[edges[i][1]] == 1) {
                // 剩下的不成环，应该删除此边
                if(!judgeCircle(edges, i)) {
                    return edges[i];
                }
            }
        }

        return null;
    }

    private boolean judgeCircle(int[][] edges, int removeEdgeIndex) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            // 假设删掉了那条边
            if (i == removeEdgeIndex)
                continue;
            // 合并失败，表明加上这条边会构成环
            if (!uf.union(edges[i][0], edges[i][1]))
                return true;
        }

        return false;
    }

    // 并查集类
    private class UnionFind{
        private int[] representNodes;

        public UnionFind(int n) {
            representNodes = new int[n + 1];
            // 初始化节点集合的代表节点为其自身
            for (int i = 1; i <= n; i++) {
                representNodes[i] = i;
            }
        }

        private int findRepresentNode(int num) {
            while(representNodes[num] != num) {
                num = representNodes[num];
            }
            return num;
        }

        private boolean union(int x, int y) {
            int rp1 = findRepresentNode(x);
            int rp2 = findRepresentNode(y);
            // 代表结点相同，说明都已经在树中,无需合并，可以删除
            if (rp1 == rp2) {
                return false;
            }
            // 若不相等，则更新并入树的节点的代表节点
            representNodes[rp1] = rp2;
            return true;
        }
    }
}

