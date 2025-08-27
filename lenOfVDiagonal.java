class Solution {
    int[][] dirs = {{-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
    int[][][][] dp;
    int m, n;
    public int lenOfVDiagonal(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new int[m][n][4][2];
        for (int[][][] layers : dp) 
            for (int[][] rows : layers)
                for (int[] cols : rows) 
                    Arrays.fill(cols, -1);
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int d = 0; d < 4; d++) {
                        ans = Math.max(ans, helper(grid, i, j, d, true, 2) + 1);
                    }
                }
            }
        }
        return ans;
    }
    public boolean check(int[][] grid, int x, int y, int t) {
        return x < 0 || y < 0 || x >= m || y >= n || grid[x][y] != t; 
    }
    public int helper(int[][] grid, int r, int c, int d, boolean turn, int tar) {
        int nr = r + dirs[d][0];
        int nc = c + dirs[d][1];
        if (check(grid, nr, nc, tar)) return 0;
        int tur = turn ? 1 : 0;
        if (dp[nr][nc][d][tur] != -1) return dp[nr][nc][d][tur];
        int max = helper(grid, nr, nc, d, turn, 2 - tar);
        if (turn) max = Math.max(max, helper(grid, nr, nc, (d + 1) % 4, false, 2 - tar));
        return dp[nr][nc][d][tur] = max + 1;
    }
}
