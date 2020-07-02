package 数组与矩阵;

public class No_566Reshape_the_Matrix_Easy {
    public static void main(String[] args) {
        int[][] nums = {{1,2},{3,4}};
        nums = matrixReshape(nums, 1, 4);
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(nums[i][j]);
            }
            System.out.println();
        }
    }

    private static int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int column = nums[0].length;
        if (r * c != row * column) {
            return nums;
        }
        int index = 0;
        int[] temp = new int[r * c];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                temp[index++] = nums[i][j];
            }
        }
        index = 0;
        int[][] array = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                array[i][j] = temp[index++];
            }
        }
        return array;
    }
}
