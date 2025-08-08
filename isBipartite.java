class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] sets = new int[n];
        Arrays.fill(sets, -1);
        for (int i = 0; i < n; i++) {
            if (sets[i] == -1) {
                if (!dfs(graph, i, 0, sets)) return false;
            }
        }
        return true;
    }

    public boolean dfs(int[][] graph, int node, int set, int[] sets) {
        sets[node] = set;
        for (int it : graph[node]) {
            if (sets[it] == -1) {
                if (!dfs(graph, it, 1 - set, sets)) return false;
            } else if (sets[it] == set) {
                return false;
            }
        }
        return true;
    }
}
