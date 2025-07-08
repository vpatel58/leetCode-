class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if (arr == null || arr.length == 0) return new int[] {};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < arr.length; i++) {
            pq.add(new int[] {arr[i], i});
        }
        int[] ans = new int[arr.length];
        int lastNum = Integer.MAX_VALUE;
        int rank = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[0] != lastNum) {
                rank++;
                lastNum = curr[0];
            }
            ans[curr[1]] = rank;
        }
        return ans;
    }
}
