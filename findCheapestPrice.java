class Solution {
    class Edges {
        int node;
        int distance;
        Edges(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
    class Price {
        int price;
        int node;
        int stops;
        Price(int price, int node, int stops) {
            this.price = price;
            this.node = node;
            this.stops = stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Edges>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : flights) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new Edges(v, wt));
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<Price> pq = new LinkedList<>();
        pq.add(new Price(0, src, 0));
        while (!pq.isEmpty()) {
            Price p = pq.poll();
            int price = p.price;
            int node = p.node;
            int stops = p.stops;
            if (stops > k) continue;
            for (Edges e : adj.get(node)) {
                int adjNode = e.node;
                int adjDist = e.distance;
                if (price + adjDist < dist[adjNode] && stops <= k) {
                    dist[adjNode] = price + adjDist;
                    pq.add(new Price(dist[adjNode], adjNode, stops + 1));
                }
            }
        }
        if (dist[dst] == Integer.MAX_VALUE) return -1;
        return dist[dst];
    }
}
