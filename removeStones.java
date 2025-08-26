class DisjointSet {
    int[] size;
    int[] parent;
    public DisjointSet(int n) {
        size = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            size[i] = 1;
            parent[i] = i;
        }
    }

    public int findUP(int node) {
        if (parent[node] == node) return node;
        int ulp = findUP(parent[node]);
        parent[node] = ulp;
        return ulp;
    }

    public void unionBySize(int u, int v) {
        int ul_u = findUP(u);
        int ul_v = findUP(v);
        if (ul_u == ul_v) return;
        if (size[ul_u] > size[ul_v]) {
            parent[ul_v] = parent[ul_u];
            size[ul_u] += size[ul_v];
        } else {
            parent[ul_u] = parent[ul_v];
            size[ul_v] += size[ul_u];
        }
    }
}
class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int r = 0, c = 0;
        for (int[] stone : stones) {
            r = Math.max(stone[0], r);
            c = Math.max(stone[1], c);
        }
        DisjointSet ds = new DisjointSet(r + c + 2);
        Set<Integer> map = new HashSet<>();
        for (int[] it : stones) {
            int rowNode = it[0];
            int colNode = it[1] + r + 1;
            ds.unionBySize(rowNode, colNode);
            map.add(rowNode);
            map.add(colNode);
        }
        int count = 0;
        for (int key : map) {
            if (ds.findUP(key) == key) count++;
        }
        return n - count;
    }
}
