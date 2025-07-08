class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) return 0;
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = countLessThan(matrix, mid);
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public int countLessThan(int[][] matrix, int target) {
        int n = matrix.length;
        int row = n - 1;
        int col = 0;
        int count = 0;
        while (row >= 0 && col < n) {
            if (matrix[row][col] <= target) {
                count = count + row + 1;
                col++;
            } else {
                row--;
            }
        }
        return count;
    }
}
