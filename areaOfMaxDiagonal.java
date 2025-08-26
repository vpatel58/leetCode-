class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int n = dimensions.length;
        double maxDiagonal = 0;
        int area = 0;
        for (int i = 0; i < n; i++) {
            int l = dimensions[i][0];
            int w = dimensions[i][1];
            double diagonal = Math.sqrt((l * l) + (w * w));
            if (diagonal > maxDiagonal) {
                maxDiagonal = diagonal;
                area = l * w;
            } else if (diagonal == maxDiagonal) {
                area = Math.max(area, l * w);
            }
        }
        return area;
    }
}
