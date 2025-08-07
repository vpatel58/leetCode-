class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        int minutes = 0, fresh = 0, rotten = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) fresh++;
                if (grid[i][j] == 2) {
                    rotten++;
                    q.add(new int[] {i, j});
                }
            }
        }
        if (fresh == 0) return 0;
        if (rotten == 0) return -1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];
                for (int[] dir : dirs) {
                    int nr = dir[0] + row;
                    int nc = dir[1] + col;
                    if (nr >= 0 && nr < m && nc >= 0 & nc < n && grid[nr][nc] == 1) {
                        fresh--;
                        grid[nr][nc] = 2;
                        q.add(new int[] {nr, nc});
                    } 
                }
            }
            minutes++;
        }
        if (fresh != 0) return -1;
        return minutes - 1;
    }
}
