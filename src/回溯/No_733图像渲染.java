package 回溯;
import java.util.*;
public class No_733图像渲染 {
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,-1,1};
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            if (image == null || image[0].length == 0) {
                return image;
            }
            int oldColor = image[sr][sc];
            if (oldColor == newColor) {
                return image;
            }
            int n = image.length, m = image[0].length;
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{sr, sc});
            image[sr][sc] = newColor;
            while(!queue.isEmpty()) {
                int[] center = queue.poll();
                int x = center[0], y = center[1];
                for (int i = 0; i < 4; i++) {
                    int nextX = x + dx[i];
                    int nextY = y + dy[i];
                    if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && image[nextX][nextY] == oldColor) {
                        image[nextX][nextY] = newColor;
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }
            return image;
        }
}
