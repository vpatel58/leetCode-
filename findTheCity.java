class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) dist[i][i] = 0;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        int city = 0;
        int reachable = 0;
        for (int j = 0; j < n; j++) {
            if (dist[0][j] != 0 && dist[0][j] <= distanceThreshold) {
                reachable++;
            }
        }
        int count = 0;
        for (int i = 1; i < n; i++) {
            count = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] != 0 && dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (count <= reachable) {
                reachable = count;
                city = i;
            }
        }
        return city;
    }
}
