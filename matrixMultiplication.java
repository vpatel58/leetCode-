class Solution {
    static int[][] dp;
    static int matrixMultiplication(int arr[]) {
        // code here
        int n = arr.length;
        dp = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(arr, 1, n - 1);
    }
    
    public static int helper(int[] nums, int i, int j) {
        if (i >= j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = helper(nums, i, k) + helper(nums, k + 1, j) + (nums[i - 1] * nums[k] * nums[j]) ;
            ans = Math.min(temp, ans);
        }
        return dp[i][j] = ans;
    }
}
