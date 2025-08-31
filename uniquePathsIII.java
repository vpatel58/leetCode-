class Solution {
    int m, n;
    int ways;
    boolean[][] visited;
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int total = 0;
        int r = 0, c = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) total++;
                if (grid[i][j] == 1) {
                    r = i;
                    c = j;
                }
            }
        }
        visited = new boolean[m][n];
        visited[r][c] = true;
        backtrack(grid, r, c, total);
        return ways;
    }
    public void backtrack(int[][] grid, int row, int col, int total) {
        if (grid[row][col] == 2) {
            if (total == -1) ways++;
            return;
        }
    
        for (int[] dir : dirs) {
            int nr = row + dir[0];
            int nc = col + dir[1];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc] && grid[nr][nc] != -1) {
                visited[nr][nc] = true;
                backtrack(grid, nr, nc, total - 1);
                visited[nr][nc] = false;
            }
        }
    }
}
