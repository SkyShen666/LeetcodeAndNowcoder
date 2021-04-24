package A剑指Offer;

public class 二位数组中的查找 {
    public boolean Find(int target, int [][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int i = 0, j = array[0].length - 1;
        while (i < array.length && j >= 0) {
            if (array[i][j] < target) {
                i++;
            }else if (array[i][j] > target) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }
}
