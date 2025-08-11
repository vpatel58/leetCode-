class Solution {
    public boolean canFinish(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(adj, i, visited, pathVisited)) return false;
            }
        }
        return true;
    }

    public boolean dfs(List<List<Integer>> adj, int node, boolean[] visited, boolean[] pathVisited) {
        visited[node] = true;
        pathVisited[node] = true;
        for (int it : adj.get(node)) {
            if (!visited[it]) {
                if (dfs(adj, it, visited, pathVisited)) return true;
            } else if (pathVisited[it]) {
                return true;
            }
        }
        pathVisited[node] = false;
        return false;
    }
}
