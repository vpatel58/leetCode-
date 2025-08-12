// User function Template for Java
class Solution {
    class Pair {
        int node;
        int dist;
        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new Pair(v, wt));
        }
        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0;i < V; i++) {
            if (!visited[i]) {
                topoSort(adj, i, visited, st);
            }
        }
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0; 
        while (!st.isEmpty()) {
            int node = st.pop();
        
            for (Pair p : adj.get(node)) {
                int u = p.node;
                int wt = p.dist;
                if (dist[node] != Integer.MAX_VALUE && dist[node] + wt < dist[u]) {
                    dist[u] = dist[node] + wt;
                }
            }
        }
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }
        return dist;
    }
    public void topoSort(List<List<Pair>> adj, int node, boolean[] visited, Stack<Integer> st) {
        visited[node] = true;
        for (Pair p : adj.get(node)) {
            int u = p.node;
            if (!visited[u]) {
                topoSort(adj, u, visited, st);
            }
        }
        st.push(node);
    }
}
