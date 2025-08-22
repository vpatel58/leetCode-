class Solution {
    public int minimumArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int top = -1, bottom = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (top == -1) {
                        top = i;
                        bottom = i;
                    } else {
                        bottom = i;
                    }
                }
            }
        }
        int left = -1, right = -1;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    if (left == -1) {
                        left = j;
                        right = j;
                    } else {
                        right = j;
                    }
                }
            }
        }
        int height = bottom - top + 1;
        int width = right - left + 1;
        return height * width;
    }
}
