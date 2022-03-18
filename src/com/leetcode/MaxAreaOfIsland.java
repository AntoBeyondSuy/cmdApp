package com.leetcode;


public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    maxArea = Math.max(maxArea, dfs(row, col, grid));
                }
            }
        }
        return maxArea;
    }

    int dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int maxArea = 1;
        maxArea += dfs(i - 1, j, grid);
        maxArea += dfs(i + 1, j, grid);
        maxArea += dfs(i, j - 1, grid);
        maxArea += dfs(i, j + 1, grid);
        return maxArea;
    }

    void test() {
        int[][] grid1 = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int[][] grid2 = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        int[][] grid3 = new int[][]{
                {0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 1, 0},
                {0, 1, 0, 0, 1, 1},
                {0, 1, 0, 0, 1, 1}};
        int[][] grid4 = new int[][]{
                {0, 1, 0, 1},
                {0, 1, 1, 1},
                {0, 0, 0, 1},
                {1, 1, 1, 0},
                {1, 1, 0, 0}};
        int[][] grid5 = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

        System.out.println(maxAreaOfIsland(grid1) + " == 6");
        System.out.println(maxAreaOfIsland(grid2) + " == 0");
        System.out.println(maxAreaOfIsland(grid3) + " == 5");
        System.out.println(maxAreaOfIsland(grid4) + " == 6");
    }
}
