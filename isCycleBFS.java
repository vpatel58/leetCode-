class Solution {
    class Pair {
        int node;
        int parent;
        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[V];
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfs(adj, visited, i)) return true;
            }
        }
        return false;
        
    }
    
    public boolean bfs(List<List<Integer>> adj, boolean[] visited, int node) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node, -1));
        visited[node] = true;
        
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int node1 = p.node;
            int parent = p.parent;
            for (int it : adj.get(node1)) {
                if (!visited[it]) {
                    visited[it] = true;
                    q.add(new Pair(it, node1));
                } else if (visited[it] && it != parent) {
                    return true;
                }
            }
        }
        return false;
    }
}
