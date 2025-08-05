class Solution {
    int[][] dp;
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] nums = new int[cuts.length + 2];
        int idx = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            nums[i] = cuts[idx++]; 
        }
        nums[nums.length - 1] = n;
        dp = new int[nums.length][nums.length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(nums, 1, cuts.length);
    }

    public int helper(int[] nums, int i, int j) {
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int mini = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int cost = (nums[j + 1] - nums[i - 1]) + helper(nums, i, k - 1) + helper(nums, k + 1, j);
            mini = Math.min(cost, mini);
        }
        return dp[i][j] = mini;
    }
}
