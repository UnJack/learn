package org.learn.tech.leetcode;

/**
 * @link 旋转n*n二维数组
 * </br>
 * <a href="https://leetcode.cn/problems/rotate-image/description/">
 * https://leetcode.cn/problems/rotate-image/description/
 * </a>
 */
public class test_matrix_rotate_print {
    //00 01 02 03    //03 13 23 33
    //10 11 12 13    //02 12 22 32
    //20 21 22 23 -> //01 11 21 31
    //30 31 32 33    //00 10 20 30
    public static void main(String[] args) {
        int[][] matrix = {
                {10, 11, 12, 13},
                {21, 22, 23, 14},
                {20, 25, 24, 15},
                {19, 18, 17, 16}
        };
        int[][] newMatrix = rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] newMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newMatrix[j][n - i - 1] = matrix[i][j];
            }
        }
        return newMatrix;
    }
}
