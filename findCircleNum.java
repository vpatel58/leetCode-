class Solution {
    public int findCircleNum(int[][] grid) {
        int n = grid.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                bfs(grid, i, visited);
            }
        }
        return count;
    }

    public void bfs(int[][] grid, int node, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int i = 0; i < grid.length; i++) {
                if (!visited[i] && grid[curr][i] == 1) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
