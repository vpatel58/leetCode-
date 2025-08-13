class Solution {
    class Pair {
        int node;
        int distance;

        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    class Dist {
        long distance;
        int node;

        Dist(long distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }

    public int countPaths(int n, int[][] roads) {
        final int MOD = 1_000_000_007;
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] edge : roads) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        PriorityQueue<Dist> pq = new PriorityQueue<>(
                (a, b) -> (a.distance == b.distance)
                        ? Integer.compare(a.node, b.node)
                        : Long.compare(a.distance, b.distance));

        long[] ways = new long[n];
        ways[0] = 1;
        pq.add(new Dist(0, 0));

        while (!pq.isEmpty()) {
            Dist d = pq.poll();
            long dis = d.distance;
            int node = d.node;
            if (dis > dist[node])
                continue;
            for (Pair p : adj.get(node)) {
                int adjNode = p.node;
                int adjDist = p.distance;
                if (adjDist + dis < dist[adjNode]) {
                    dist[adjNode] = adjDist + dis;
                    ways[adjNode] = ways[node] % MOD;
                    pq.add(new Dist(dist[adjNode], adjNode));
                } else if (adjDist + dis == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % MOD;
                }
            }
        }
        return (int) (ways[n - 1] % MOD);
    }
}
