// User function Template for Java
class DisjointSet {
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    DisjointSet(int n) {
        for (int i = 0; i < n; i++) {
            size.add(1);
            parent.add(i);
        }
    }
    
    public int findUP(int node) {
        if (parent.get(node) == node) return node;
        int ulp = findUP(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    
    public void unionBySize(int u,int v) {
        int ul_u = findUP(u);
        int ul_v = findUP(v);
        if (ul_u == ul_v) return;
        if (size.get(ul_u) < size.get(ul_v)) {
            size.set(ul_v, size.get(ul_u) + size.get(ul_v));
            parent.set(ul_u, ul_v);
        } else {
            size.set(ul_u, size.get(ul_u) + size.get(ul_v));
            parent.set(ul_v, ul_u);
        }
    }
}
class Solution {
    static class Pair {
        int wt;
        int u;
        int v;
        public Pair(int wt, int u, int v) {
            this.wt = wt;
            this.u = u;
            this.v = v;
        }
    }
    static int kruskalsMST(int V, int[][] edges) {
        // code here
    
        DisjointSet ds = new DisjointSet(V);
        Arrays.sort(edges, (a, b) -> {
            return a[2] - b[2];
        });
        
        int mstWt = 0;
        // M x 4 x alpha x 2
        for (int i = 0; i < edges.length; i++) {
            int wt = edges[i][2];
            int u = edges[i][0];
            int v = edges[i][1];

            if (ds.findUP(u) != ds.findUP(v)) {
                mstWt += wt;
                ds.unionBySize(u, v);
            }
        }

        return mstWt;
    }
}
