class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        int maxPoints = 0;
        for (int i = 0; i < n; i++) {
            HashMap<Double, Integer> map = new HashMap<>();
            int overlap = 0;
            int currMax = 0;
            int[] row1 = points[i];
            for (int j = i + 1; j < n; j++) {
                int[] row2 = points[j];
                int y2 = row2[1], y1 = row1[1];
                int x2 = row2[0], x1 = row1[0];
                if (x1 == x2 && y1 == y2) {
                    overlap++;
                } else {
                    double slope;
                    if (x2 == x1) {
                        slope = Double.POSITIVE_INFINITY;
                    } else if (y2 == y1) {
                        slope = 0.0;
                    } else {
                        slope = (double)(y2 - y1) / (x2 - x1);
                    }
                    map.put(slope, map.getOrDefault(slope, 0) + 1);
                    currMax = Math.max(currMax, map.get(slope));
                }   
            }
            maxPoints = Math.max(maxPoints, currMax + overlap + 1);
        }
        return maxPoints;
    }
}
