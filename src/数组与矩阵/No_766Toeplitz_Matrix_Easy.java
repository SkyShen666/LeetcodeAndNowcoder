package 数组与矩阵;

public class No_766Toeplitz_Matrix_Easy {
    public static void main(String[] args) {
        int[][] matrix = {{1,1},{2,2}};
        boolean rs = isToeplitzMatrix(matrix);
        System.out.println(rs);
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix.length == 1 || matrix[0].length == 1) {
            return true;
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
