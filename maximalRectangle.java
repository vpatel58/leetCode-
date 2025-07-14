class Solution {
    
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp = new int[n + 1];
        int area = 0;
        for (int i = 1; i < m + 1; i++) {
            Stack<Integer> s = new Stack<>();
            for (int j = 0; j < n + 1; j++) {
                int curr = 0;
                if (j != n) {
                    if (matrix[i - 1][j] == '1') {
                        dp[j] = 1 + dp[j];
                    }  else {
                        dp[j] = 0;
                    }
                    curr = dp[j];
                }
                while (!s.isEmpty() && curr < dp[s.peek()]) {
                    int top = s.pop();
                    int height = dp[top];
                    int width = s.isEmpty() ? j : j - s.peek() - 1;
                    area = Math.max(area, height * width);
                }
                s.push(j);
            }
        }
        return area;
    }

}
