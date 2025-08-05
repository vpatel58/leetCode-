class Solution {
    int[][] dp;
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[] arr = new int[len + 2];
        arr[0] = 1;
        arr[len + 1] = 1;
        for (int i = 0; i < len; i++) {
            arr[i + 1] = nums[i];
        }
        dp = new int[arr.length][arr.length];
        for (int i = len; i >= 1; i--) {
            for (int j = 1; j <= len; j++) {
                if (i > j) continue;
                int max = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    int cost = (arr[i - 1] * arr[k] * arr[j + 1]) + dp[i][k - 1] + dp[k + 1][j];
                    max = Math.max(max, cost);
                }
                dp[i][j] = max;
            }
        }
        return dp[1][len];
    }
}
