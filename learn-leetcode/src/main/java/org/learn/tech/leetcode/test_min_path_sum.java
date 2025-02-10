package org.learn.tech.leetcode;

/**
 * @link 最小路径之和
 * </br>
 * <a href="https://leetcode.cn/problems/0i0mDW/solutions/1398905/zui-xiao-lu-jing-zhi-he-by-leetcode-solu-y7tx/">
 * https://leetcode.cn/problems/0i0mDW/solutions/1398905/zui-xiao-lu-jing-zhi-he-by-leetcode-solu-y7tx/
 * </a>
 */
public class test_min_path_sum {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 4},
                {4, 2, 1}
        };
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];

        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < columns; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][columns - 1];
    }
}
