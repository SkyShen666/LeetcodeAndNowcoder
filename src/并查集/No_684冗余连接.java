package 并查集;

/**
 * https://leetcode-cn.com/problems/redundant-connection/solution/tong-su-jiang-jie-bing-cha-ji-bang-zhu-xiao-bai-ku/
 * 参考此题解
 */
public class No_684冗余连接 {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] rpNode = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            rpNode[i] = i;
        }

        for (int i = 0; i < n; i++) {
            int rp1 = findRepresentNode(edges[i][0], rpNode);
            int rp2 = findRepresentNode(edges[i][1], rpNode);
            // 若两个代表结点相等，说明出这俩都在树里面，出现了环
            if (rp1 == rp2) {
                return edges[i];
            } else {
                // 若不相等，则更新并入树的结点的代表结点
                rpNode[rp1] = rp2;
            }
        }
        return null;
    }

    private int findRepresentNode(int num, int[] rpNode) {
        while(rpNode[num] != num) {
            num = rpNode[num];
        }
        return num;
    }
}
