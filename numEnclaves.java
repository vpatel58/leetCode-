class Solution {
    int m, n;
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int numEnclaves(int[][] board) {
        m = board.length;
        n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 1 && !visited[0][j]) {
                dfs(board, 0, j, visited);
            }
            if (board[m - 1][j] == 1 && !visited[m - 1][j]) {
                dfs(board, m - 1, j, visited);
            }
        }
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 1 && !visited[i][0]) {
                dfs(board, i, 0, visited);
            }
            if (board[i][n - 1] == 1 && !visited[i][n - 1]) {
                dfs(board, i, n - 1, visited);
            }
        }
        int count = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int[][] board, int r, int c, boolean[][] visited) {
        visited[r][c] = true;
        for (int[] dir : dirs) {
            int nr = dir[0] + r;
            int nc = dir[1] + c;
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && board[nr][nc] == 1 && !visited[nr][nc]) {
                dfs(board, nr, nc, visited);
            } 
        }
    }
}
