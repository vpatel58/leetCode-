class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int org = image[sr][sc];
        if (org == color) return image;
        int m = image.length;
        int n = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {sr, sc});
        image[sr][sc] = color;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int[] dir : dirs) {
                int nr = dir[0] + curr[0];
                int nc = dir[1] + curr[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == org) {
                    q.add(new int[] {nr, nc});
                    image[nr][nc] = color;
                }
            }
        }
        return image;
    }
}
