class Solution {
    static int matrixMultiplication(int nums[]) {
        // code here
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = 0;
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j < n; j++) {
                int ans = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int temp = dp[i][k] + dp[k + 1][j] + (nums[i - 1] * nums[k] * nums[j]) ;
                    ans = Math.min(temp, ans);
                }
                dp[i][j] = ans;
            }
        }
        return dp[1][n - 1];
    }
    
   
}
