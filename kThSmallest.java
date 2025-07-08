class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < matrix.length; i++) {
            pq.add(new int[] {matrix[i][0], i, 0});
        }
        int res = 0;
        while (k-- > 0) {
            int[] curr = pq.poll();
            int row = curr[1];
            res = curr[0];
            int col = curr[2];
            if (col + 1 < matrix.length) {
                pq.add(new int[] {matrix[row][col + 1], row, col + 1});
            }
        }
        return res;
    } 
}
