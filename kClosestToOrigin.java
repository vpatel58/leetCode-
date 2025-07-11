class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        for (int i = 0; i < n; i++) {
            int[] p1 = points[i];
            int dist = getDistance(p1[0], p1[1], 0 , 0);
            pq.add(new int[] {dist, p1[0], p1[1]});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[][] ans = new int[k][];
        int idx = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            ans[idx++] = new int[] {(int)curr[1], (int)curr[2]};
        }
        return ans;
    }

    private int getDistance(int x1, int y1, int x2, int y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }
}
