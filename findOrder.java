class Solution {
    public int[] findOrder(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(v).add(u);
        }
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(adj, i, visited, st, pathVisited)) {
                    return new int[] {};
                }
            }
        }
        int[] ans = new int[V];
        int idx = 0;
        while (!st.isEmpty()) {
            ans[idx++] = st.pop();
        }
        return ans;
    }

    public boolean dfs(List<List<Integer>> adj, int node, boolean[] visited, Stack<Integer> st, boolean[] pathVisited) {
        visited[node] = true;
        pathVisited[node] = true;
        for (int it : adj.get(node)) {
            if (!visited[it]) {
                if (dfs(adj, it, visited, st, pathVisited)) {
                    return true;
                }
            } else if (pathVisited[it]) {
                return true;
            }
        }
        pathVisited[node] = false;
        st.push(node);
        return false;
    }
}
