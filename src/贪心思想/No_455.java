package 贪心思想;

import java.util.Arrays;

//贪心思想：保证每次操作都是局部最优的，并且最后得到的结果是全局最优的。
public class No_455 {
    public static void main(String[] args) {
        int[] greed = {1,2};
        int[] child = {1,2,3};
        int count = findContentChildren(greed,child);
        System.out.println(count);
    }

    public static int findContentChildren(int[] g, int[] s) {
        if(g != null && s != null){
            Arrays.sort(g);
            Arrays.sort(s);
        }
        int i = 0,j = 0;
        int count = 0;
        while ( i < g.length && j < s.length ){
            if(g[i] <= s[j]){
                i++;
                j++;
                count++;
            }else {
                j++;
            }
        }
        return count;
    }
}
