package 数组与矩阵;
import java.util.*;

public class No_1122数组的相对排序 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map =  new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : arr1) {
            list.add(num);
        }
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        Collections.sort(list, (x, y) -> {
            if (map.containsKey(x) || map.containsKey(y)) {
                // getOrDefault方法,若是不在map中,只是返回一个默认值,并不会再添加进map中.
                // 一般想添加进map中,与map.put()配合使用
                return map.getOrDefault(x, 1001) - map.getOrDefault(y, 1001);
            }
            return x - y;
        });
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = list.get(i);
        }
        return arr1;
    }
}
