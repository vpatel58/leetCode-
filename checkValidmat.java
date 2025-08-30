class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            boolean[] rowSeen = new boolean[n + 1];
            boolean[] colSeen = new boolean[n + 1];

            for (int j = 0; j < n; j++) {
                int rowVal = matrix[i][j];
                int colVal = matrix[j][i];

                if (rowVal < 1 || rowVal > n || rowSeen[rowVal]) return false;
                rowSeen[rowVal] = true;

                if (colVal < 1 || colVal > n || colSeen[colVal]) return false;
                colSeen[colVal] = true;
            }
        }

        return true;
    }
}
