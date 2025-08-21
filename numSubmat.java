class Solution {
    public int numSubmat(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int[][] height = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (mat[r][c] == 0) {
                    height[r][c] = 0;
                } else {
                    height[r][c] = (r == 0 ? 1 : height[r - 1][c] + 1);
                }
            }
        }
        int total = 0;
        for (int r = 0; r < rows; r++) {
            total += countRow(height[r]);
        }

        return total;
    }

    private int countRow(int[] heights) {
        int n = heights.length;
        int[] sum = new int[n]; // sum[i] = number of submatrices ending at i
        java.util.Stack<Integer> stack = new java.util.Stack<>();

        int rowCount = 0;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                int prev = stack.peek();
                sum[i] = sum[prev] + heights[i] * (i - prev);
            } else {
                sum[i] = heights[i] * (i + 1);
            }

            stack.push(i);
            rowCount += sum[i];
        }

        return rowCount;
    }
}
