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
        int distance;
        int node;
        Dist(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) adj.add(new ArrayList<>());
        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new Pair(v, wt));
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<Dist> pq = new PriorityQueue<>((a, b) -> {
            if (a.distance == b.distance) return a.node - b.node;
            return a.distance - b.distance;
        });
        pq.add(new Dist(0, k));
        while (!pq.isEmpty()) {
            Dist d = pq.poll();
            int dis = d.distance;
            int node = d.node;
            for (Pair p : adj.get(node)) {
                int adjNode = p.node;
                int adjDist = p.distance;
                if (adjDist + dis < dist[adjNode]) {
                    dist[adjNode] = adjDist + dis;
                    pq.add(new Dist(dist[adjNode], adjNode));
                }
            }
        }
        int mini = Integer.MIN_VALUE;
        for (int i = 1; i < n + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            mini = Math.max(mini, dist[i]);
        }
        return mini;
        
    }
}
