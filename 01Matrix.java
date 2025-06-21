class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0) return new int[][] {};

        Queue<int[]> q = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) q.add(new int[] {i, j});
                else mat[i][j] = Integer.MAX_VALUE;
            }
        }
        while (!q.isEmpty()) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                        if (mat[nr][nc] > mat[curr[0]][curr[1]]+ 1 ) {
                            mat[nr][nc] = mat[curr[0]][curr[1]] + 1;
                            q.add(new int[] {nr, nc});
                        }
                        
                    }
                }
        }

        return mat;
    }
}
