class Solution {
    int m, n;
    int[][] dp;
    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1); 
        }
        return helper(grid, 0, 0);
    }
    public int helper(int[][] grid, int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n) {
            return Integer.MAX_VALUE;
        }
        if (r == m - 1 && c == n - 1) {
            return grid[r][c];
        }
        if (dp[r][c] != -1) return dp[r][c];

        int case1 = helper(grid, r, c + 1);
        int case2 = helper(grid, r + 1, c);

        return dp[r][c] = grid[r][c] + Math.min(case1, case2);
    }
}
