class Solution {
    int paths;
    int m, n;
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(grid, 0, 0);
    }

    public int helper(int[][] grid, int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return 0;
        }
        if (grid[row][col] == 1) {
            return 0;
        }
        if (row == m - 1 && col == n - 1) {
            return 1;
        }
        if (dp[row][col] != -1) return dp[row][col];
        int case1 = helper(grid, row, col + 1);
        int case2 = helper(grid, row + 1, col);
        return dp[row][col] = case1 + case2;
    }
}
