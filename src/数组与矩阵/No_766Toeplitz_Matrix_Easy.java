package 数组与矩阵;

public class No_766Toeplitz_Matrix_Easy {
    public static void main(String[] args) {
        int[][] matrix = {{1,1},{2,2}};
        boolean rs = isToeplitzMatrix(matrix);
        System.out.println(rs);
    }

    /**
     * [1,2,3,4], a[0][0]-a[1][1]-a[2][2]
     * [5,1,2,3], a[0][1]-a[1][2]-a[2][3]
     * [9,5,1,2]
     * @param matrix
     * @returnss
     */
    private static boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            if (!check(matrix,i,0)) {
                return false;
            }
        }

        for (int j = 0; j < matrix[0].length - 1; j++) {
            if (!check(matrix,0,j)) {
                return false;
            }
        }
        return true;
    }

    private static boolean check(int[][] matrix,int i,int j) {
        while (i < matrix.length -1 && j < matrix[i].length -1) {
            if (matrix[i][j] != matrix[i + 1][j + 1]) {
                return false;
            } else {
                i++;
                j++;
            }
        }
        return true;
    }
}
