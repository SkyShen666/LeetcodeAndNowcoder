package 数学;
import java.util.*;

/**
 * 蓄水池抽样（Reservoir Sampling ）能够在o（n）时间内对n个数据进行等概率随机抽取，
 * 对于未知的大小的数据抽样效果很好，而且能够应对数据一直增加的情况。
 *
 * 蓄水池抽样的主要思想是，先选定第一个样本，而后的第i个样本有1 / i 的几率替换之前的样本，
 * 可以证明，每个节点最终被选中的概率都是1/n，
 * 证明过程可以参照这篇博文。http://www.cnblogs.com/hrlnw/archive/2012/11/27/2777337.html
 */
public class 蓄水池抽样算法 {
    public static int[] randomReservoir(int[] datastream, int m) {
        int[] reservoir = new int[m];

        for (int i = 0; i < m; i++) {
            reservoir[i] = datastream[i];
        }

        int n = datastream.length;
        for (int i = m; i < n; i++) {
            int num = new Random().nextInt(i + 1);
            if (num < m) {
                reservoir[num] = datastream[i];
            }
        }
        return reservoir;
    }

    public static void main(String[] args) {
        int[] datastream = new int[]{1,2,3,4,5,6,7,8,9,10};
        int m = 3;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10000000; i++) {
            int[] res = randomReservoir(datastream, m);
            for (int j = 0; j < m; j++) {
                map.put(res[j], map.getOrDefault(res[j], 1) + 1);
            }
        }
        System.out.println(map);
    }
}
