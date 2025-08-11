class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!dfs(graph, i, visited, pathVisited)) {
                result.add(i);
            }
        }
        return result;
    }

    public boolean dfs(int[][] graph, int node, boolean[] visited, boolean[] pathVisited) {
        visited[node] = true;
        pathVisited[node] = true;
        for (int it : graph[node]) {
            if (!visited[it]) {
                if (dfs(graph, it, visited, pathVisited)) return true;
            } else if (pathVisited[it]) {
                return true;
            }
        }
        pathVisited[node] = false;
        return false;
    }
}
