package org.learn.tech.leetcode;

/**
 * @link 螺旋遍历二维数组
 * </br>
 * <a href="https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/description/">
 * https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/description/
 * </a></br>
 * <a href="https://leetcode.cn/problems/spiral-matrix/description/">
 * https://leetcode.cn/problems/spiral-matrix/description/
 * </a>
 */
public class test_matrix_spiral_print {

    public static void main(String[] args) {
        int[][] matrix = {
                {10, 11, 12, 13},
                {21, 22, 23, 14},
                {20, 25, 24, 15},
                {19, 18, 17, 16}
        };
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        while (true) {
            //从左往右
            for (int col = left; col <= right; col++) {
                System.out.println(matrix[top][col]);
            }
            if (++top > bottom) {
                break;
            }
            //从上往下
            for (int row = top; row <= bottom; row++) {
                System.out.println(matrix[row][right]);
            }
            if (--right < left) {
                break;
            }
            //从右往左
            for (int col = right; col >= left; col--) {
                System.out.println(matrix[bottom][col]);
            }
            if (--bottom < top) {
                break;
            }
            //从下往上
            for (int row = bottom; row >= top; row--) {
                System.out.println(matrix[row][left]);
            }
            if (++left > right) {
                break;
            }
        }
    }
}
