package 回溯;

import java.util.*;

// BFS
// 参考题解
// https://leetcode-cn.com/problems/flood-fill/solution/mo-ban-ti-jian-dan-yi-yu-li-jie-de-java-dfshe-bfs-/
public class No_733图像渲染 {
    private static final int[] di = {1, -1, 0, 0};
    private static final int[] dj = {0, 0, -1, 1};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0) {
            return image;
        }

        int n = image.length;
        int m = image[0].length;
        int oldColor = image[sr][sc];
        if (oldColor == newColor) {
            return image;
        }

        image[sr][sc] = newColor;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        while (!queue.isEmpty()) {
            int[] center = queue.poll();
            int i = center[0], j = center[1];
            for (int k = 0; k < 4; k++) {
                int nextI = i + di[k];
                int nextJ = j + dj[k];
                if (nextI >= 0 && nextI < n && nextJ >= 0 && nextJ < m && image[nextI][nextJ] == oldColor) {
                    image[nextI][nextJ] = newColor;
                    queue.offer(new int[]{nextI, nextJ});
                }
            }
        }

        return image;
    }
}

// DFS:
//
//    private static final int[] di = {1, -1, 0, 0};
//    private static final int[] dj = {0, 0, -1, 1};
//    private int[][] image;
//    private int m;
//    private int n;
//    private int newColor;
//
//    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
//        if (image == null || image.length == 0) {
//            return image;
//        }
//
//        this.image = image;
//        m = image.length;
//        n = image[0].length;
//        this.newColor = newColor;
//        int oldColor = image[sr][sc];
//
//        if (oldColor == newColor) {
//            return image;
//        }
//        dfs(sr, sc, oldColor);
//
//        return image;
//    }
//
//    private void dfs(int i, int j, int oldColor) {
//        if (i < 0 || i >= m || j < 0 || j >= n || image[i][j] != oldColor) {
//            return;
//        }
//
//        image[i][j] = newColor;
//        for (int k = 0; k < 4; k++) {
//            int nextI = i + di[k];
//            int nextJ = j + dj[k];
//            dfs(nextI, nextJ, oldColor);
//        }
//    }